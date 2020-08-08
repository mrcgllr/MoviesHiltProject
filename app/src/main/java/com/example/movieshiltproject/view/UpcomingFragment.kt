package com.example.movieshiltproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movieshiltproject.R
import com.example.movieshiltproject.adapter.MovieAdapter
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.viewmodel.UpcomingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_upcoming_movies.*

@AndroidEntryPoint
class UpcomingFragment : Fragment(R.layout.fragment_upcoming_movies) {

    private val viewModel by viewModels<UpcomingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter{
            val dialog = DialogBottomMovieDetailFragment(it)
            dialog.show(childFragmentManager, null)
        }
        upcoming_recycler.adapter = adapter

        viewModel.getUpcomingMovies()
        viewModel.upcomingMovieList.observe(viewLifecycleOwner, Observer { resources ->
            when (resources) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    upcoming_progress_bar.visibility = View.GONE
                    adapter.submitList(resources.data?.results)
                }
                is Resource.Failed -> {
                }
                is Resource.Exception -> {
                }


            }

        })


    }
}
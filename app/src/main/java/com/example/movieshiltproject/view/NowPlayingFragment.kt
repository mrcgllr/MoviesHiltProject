package com.example.movieshiltproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movieshiltproject.R
import com.example.movieshiltproject.adapter.MovieAdapter
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.viewmodel.NowPlayingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_now_playing_movies.*

@AndroidEntryPoint
class NowPlayingFragment : Fragment(R.layout.fragment_now_playing_movies) {

    private val viewModel by viewModels<NowPlayingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter{
            val dialog = DialogBottomMovieDetailFragment(it)
            dialog.show(childFragmentManager, null)
        }
        now_playing_recycler.adapter = adapter

        viewModel.getNowPlayingMovies()

        viewModel.nowPlayingMoviesList.observe(viewLifecycleOwner, Observer { resources ->
            when (resources) {

                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    now_playing_progress_bar.visibility = View.GONE
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
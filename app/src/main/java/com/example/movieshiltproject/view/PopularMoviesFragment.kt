package com.example.movieshiltproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movieshiltproject.R
import com.example.movieshiltproject.adapter.MovieAdapter
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.viewmodel.PopularMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_popular_movies.*


@AndroidEntryPoint
class PopularMoviesFragment : Fragment(R.layout.fragment_popular_movies) {

    private val viewModel by viewModels<PopularMoviesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter {
            val dialog = DialogBottomMovieDetailFragment(it)
            dialog.show(childFragmentManager, null)
        }
        recyc_popular_movie.adapter = adapter

        viewModel.getPopularMovies()
        viewModel.popularMoviesList.observe(viewLifecycleOwner, Observer { resources ->

            when (resources) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    progress_bar.visibility = View.GONE
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
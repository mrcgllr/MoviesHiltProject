package com.example.movieshiltproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.movieshiltproject.R
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.util.Constant.IMAGE_URL_ORIGINAL
import com.example.movieshiltproject.viewmodel.MovieDetailViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_bottom_movie_detail.view.*

@AndroidEntryPoint
class DialogBottomMovieDetailFragment(private val movieId: Int) : BottomSheetDialogFragment() {

    private val viewModel by viewModels<MovieDetailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_bottom_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getMovieDetail(movieId)
        viewModel.movieDetail.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    with(view) {
                        bottom_progress_bar.visibility = View.GONE

                        with(bottom_movie_image) {
                            visibility = View.VISIBLE
                            Glide.with(view.context)
                                .load(IMAGE_URL_ORIGINAL + resource.data?.backdropPath)
                                .into(this)
                        }
                        with(bottom_movie_vote_average) {
                            text = resource.data?.voteAverage.toString()
                            this.visibility = View.VISIBLE
                        }
                        with(bottom_movie_release_date) {
                            text = resource.data?.releaseDate.toString()
                            this.visibility = View.VISIBLE
                        }
                        with(bottom_movie_popularity) {
                            text = resource.data?.popularity.toString()
                            this.visibility = View.VISIBLE
                        }
                        with(bottom_movie_overview) {
                            text = resource.data?.overview.toString()
                            this.visibility = View.VISIBLE
                        }
                        with(bottom_movie_name){
                            text = resource.data?.title.toString()
                            this.visibility = View.VISIBLE
                        }

                    }


                }
                is Resource.Failed -> {
                }
                is Resource.Exception -> {
                }
            }
        })
    }
}
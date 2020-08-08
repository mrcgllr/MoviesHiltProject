package com.example.movieshiltproject.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieshiltproject.R
import com.example.movieshiltproject.model.Result
import com.example.movieshiltproject.util.Constant.IMAGE_URL
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieViewHolder(container: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(container.context).inflate(R.layout.list_item_movie, container, false)
    ) {

    fun bind(movie: Result, onItemClickListener: (Int) -> Unit) {
        if (movie.title == "" || movie.overview == "") {
        } else {
            Log.d("MOVİE", movie.toString())
            Glide.with(itemView.context).load(IMAGE_URL + movie.backdropPath)
                .into(itemView.list_item_movie_poster)
            itemView.list_item_movie_title.text = movie.title
            itemView.list_item_movie_release_date.text = movie.releaseDate
            itemView.list_item_movie_vote_average.text = movie.voteAverage.toString()
        }


        itemView.setOnClickListener {
            onItemClickListener(movie.id!!)
        }
    }
}
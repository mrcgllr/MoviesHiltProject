package com.example.movieshiltproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movieshiltproject.model.Result

class MovieAdapter(private val onItemClickListener:(Int)->Unit) : ListAdapter<Result, MovieViewHolder>(DiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position),onItemClickListener)


}
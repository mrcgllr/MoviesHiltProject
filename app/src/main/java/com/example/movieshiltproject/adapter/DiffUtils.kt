package com.example.movieshiltproject.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.movieshiltproject.model.Result

class DiffUtils : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean = oldItem == newItem
}
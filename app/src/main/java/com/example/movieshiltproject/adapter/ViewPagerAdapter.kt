package com.example.movieshiltproject.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieshiltproject.model.FragmentModel

class ViewPagerAdapter(
    container: FragmentActivity,
    private val fragmentList: List<FragmentModel>
) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position].fragment


}
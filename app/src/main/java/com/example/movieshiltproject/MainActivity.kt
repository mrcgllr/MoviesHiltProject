package com.example.movieshiltproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.movieshiltproject.adapter.ViewPagerAdapter
import com.example.movieshiltproject.model.FragmentModel
import com.example.movieshiltproject.view.NowPlayingFragment
import com.example.movieshiltproject.view.PopularMoviesFragment
import com.example.movieshiltproject.view.TopRatedFragment
import com.example.movieshiltproject.view.UpcomingFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerList =
            listOf(
                FragmentModel("Popüler", PopularMoviesFragment()),
                FragmentModel("Vizyondakiler", NowPlayingFragment()),
                FragmentModel("Yakında Gelecekler", UpcomingFragment()),
                FragmentModel("En Fazla Oy", TopRatedFragment())
            )
        viewpager.adapter = ViewPagerAdapter(this, pagerList)
        initTabLayout(pagerList)

    }

    private fun initTabLayout(pagerList: List<FragmentModel>) {
        TabLayoutMediator(tab_layout, viewpager) { tab, position ->
            tab.text = pagerList[position].fragmentTitle
            viewpager.setCurrentItem(tab.position, true)
        }.attach()
    }
}
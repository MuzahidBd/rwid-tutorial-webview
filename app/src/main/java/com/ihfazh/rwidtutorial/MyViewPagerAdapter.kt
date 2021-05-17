package com.ihfazh.rwidtutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> WebViewFragment("https://remoteworker.id/blog/blog-1?affid=47ZY8rGf")
            else -> WebViewFragment("https://remoteworker.id/promo?affid=47ZY8rGf")
        }
    }
}
package com.saad.todoapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.saad.todoapp.fragments.BuyListFragment
import com.saad.todoapp.fragments.CallListFragment
import com.saad.todoapp.fragments.SellListFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                CallListFragment()
            }

            1 -> {
                BuyListFragment()
            }

            else -> {
                SellListFragment()
            }
        }
    }
}
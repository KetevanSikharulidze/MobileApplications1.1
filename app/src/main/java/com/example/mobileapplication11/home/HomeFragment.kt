package com.example.mobileapplication11.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapplication11.R
import com.example.mobileapplication11.adapters.ViewPagerAdapter
import com.example.mobileapplication11.databinding.FragmentHomeBinding
import com.example.mobileapplication11.databinding.FragmentHomePostsBinding
import com.example.mobileapplication11.home.homePosts.DirectMessagesFragment
import com.example.mobileapplication11.home.homePosts.HomePostsFragment
import com.example.mobileapplication11.home.homePosts.StoryCameraFragment

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val fList = listOf(
        StoryCameraFragment.newInstance(),
        HomePostsFragment.newInstance(),
        StoryCameraFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setupViewPager(viewPager: ViewPager2, fragmentActivity: FragmentActivity) {
        val adapter = ViewPagerAdapter(fragmentActivity, fList)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(1, false) // `false` disables animation during the initial set
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(homePlaceHolder, requireActivity())
    }

    companion object {
       @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
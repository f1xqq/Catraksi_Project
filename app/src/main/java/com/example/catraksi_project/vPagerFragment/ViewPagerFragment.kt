package com.example.catraksi_project.vPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentViewPagerBinding
import com.example.catraksi_project.vPagerFragment.onBoarding.OnBoarding1Fragment
import com.example.catraksi_project.vPagerFragment.onBoarding.OnBoarding2Fragment
import com.example.catraksi_project.vPagerFragment.onBoarding.OnBoarding3Fragment

class ViewPagerFragment : Fragment() {

    lateinit var  binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            OnBoarding1Fragment(),
            OnBoarding2Fragment(),
            OnBoarding3Fragment()
        )

        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return  view
    }

}
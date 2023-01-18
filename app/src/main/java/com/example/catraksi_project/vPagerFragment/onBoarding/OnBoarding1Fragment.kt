package com.example.catraksi_project.vPagerFragment.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentOnBoarding1Binding

class OnBoarding1Fragment : Fragment() {
    private  lateinit var  binding : FragmentOnBoarding1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding1,
            container, false)
        binding = FragmentOnBoarding1Binding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next1.setOnClickListener{
            viewPager?.currentItem = 1
        }

        binding.lewati1.setOnClickListener{
            viewPager?.currentItem = 2
        }
        return view
    }
}
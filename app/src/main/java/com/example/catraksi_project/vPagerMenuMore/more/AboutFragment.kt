package com.example.catraksi_project.vPagerMenuMore.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private  lateinit var  binding : FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about,
            container, false)
        binding = FragmentAboutBinding.bind(view)
        val viewPagerMore = activity?.findViewById<ViewPager2>(R.id.viewPagerMore)

        binding.backTentang.setOnClickListener{
            viewPagerMore?.currentItem = 0
        }
        return view
    }
}
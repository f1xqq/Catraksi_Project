package com.example.catraksi_project.vPagerFragment.onBoarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentOnBoarding3Binding

class OnBoarding3Fragment : Fragment() {

    private  lateinit var  binding : FragmentOnBoarding3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding3,
            container, false)

        binding = FragmentOnBoarding3Binding.bind(view)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.mulai.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginAplikasiActivity)

        }

        binding.back2.setOnClickListener{
            viewPager?.currentItem = 1
        }

        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Selesai", true)
        editor.apply()
    }
}
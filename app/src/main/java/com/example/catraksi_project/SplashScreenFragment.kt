package com.example.catraksi_project

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler().postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(
                    R.id.action_splashScreenFragment_to_loginAplikasiActivity
                )
            }else{
                findNavController().navigate(
                    R.id.action_splashScreenFragment_to_viewPagerFragment
                )
            }
        }, 3000)

        return  inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().
        getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return  sharedPref.getBoolean("Selesai", false)
    }
}
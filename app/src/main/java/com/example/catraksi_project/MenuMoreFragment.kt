package com.example.catraksi_project

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.catraksi_project.databinding.FragmentMenuMoreBinding

class MenuMoreFragment : Fragment() {
    private  lateinit var  binding : FragmentMenuMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_more,
            container, false)
        binding = FragmentMenuMoreBinding.bind(view)
        val viewPagerMore = activity?.findViewById<ViewPager2>(R.id.viewPagerMore)

        binding.menuPengguna.setOnClickListener{
            viewPagerMore?.currentItem = 1
        }

        binding.menuTentang.setOnClickListener{
            viewPagerMore?.currentItem = 2
        }

        return view

    }

}
package com.example.catraksi_project.vPagerMenuMore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catraksi_project.MenuMoreFragment
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentViewPagerMoreBinding
import com.example.catraksi_project.vPagerMenuMore.more.AboutFragment
import com.example.catraksi_project.vPagerMenuMore.more.UserFragment


class ViewPagerMoreFragment : Fragment() {
    lateinit var  binding: FragmentViewPagerMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager_more, container, false)
        binding = FragmentViewPagerMoreBinding.bind(view)
        val fragmentList = arrayListOf(
            MenuMoreFragment(),
            UserFragment(),
            AboutFragment()
        )

        val adapter = ViewPagerAdapterMore(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPagerMore.adapter = adapter
        return  view
    }
}
package com.example.catraksi_project.vPagerMenuMore.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.catraksi_project.R
import com.example.catraksi_project.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    private  lateinit var  binding : FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user,
            container, false)
        binding = FragmentUserBinding.bind(view)
        val viewPagerMore = activity?.findViewById<ViewPager2>(R.id.viewPagerMore)

        binding.backToMenuMorePengguna.setOnClickListener{
            viewPagerMore?.currentItem = 0
        }
        return view
    }
}
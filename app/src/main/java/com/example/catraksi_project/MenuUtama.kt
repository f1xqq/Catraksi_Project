package com.example.catraksi_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.catraksi_project.FragmentMenu.BulananFragment
import com.example.catraksi_project.FragmentMenu.HarianFragment
import com.google.android.material.tabs.TabLayout

class MenuUtama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_menu_utama)
            val toolbar: Toolbar = findViewById(R.id.toolbar_atas)
//            supportActionBar!!.title= ""

            val tabLayout: TabLayout = findViewById(R.id.tab_layout)
            val viewPager: ViewPager = findViewById(R.id.view_pager)
            val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

            viewPagerAdapter.tambahFragment(HarianFragment(), "Harian")
            viewPagerAdapter.tambahFragment(BulananFragment(), "Bulanan")

            viewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(viewPager)
        }

        internal class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(
            fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ){
            private val fragments: ArrayList<Fragment>
            private val juduls:ArrayList<String>

            init {
                fragments= ArrayList()
                juduls = ArrayList()
            }
            override fun getCount(): Int {
                return fragments.size
            }
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            fun tambahFragment(fragment: Fragment, judul: String){
                fragments.add(fragment)
                juduls.add(judul)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return juduls[position]
            }
        }

    fun keMenuMore(view: View?){
        val i = Intent(applicationContext, MoreActivity::class.java)
        i.putExtra("Value1", "Halaman Lainnyar")
        startActivity(i)
    }
}
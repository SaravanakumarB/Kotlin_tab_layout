package com.example.saravanakumar.kotlin_tab_layout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolBarLayout.setTitle("Tab layout")

        val pageAdapter = PageAdapter(supportFragmentManager)

        // create fragments from 0 to 9
        for (i in 0 until 10) {
            pageAdapter.add(PageFragment.newInstance(i), "Tab$i")
        }

        view_pager.adapter = pageAdapter
        tabs.setupWithViewPager(view_pager)
    }

    class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val tabNames: ArrayList<String>
        private val fragments: ArrayList<Fragment>

        init {
            tabNames = ArrayList()
            fragments = ArrayList()
        }

        fun add(fragment: Fragment, title: String) {
            tabNames.add(title)
            fragments.add(fragment)
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tabNames[position]
        }
    }

}

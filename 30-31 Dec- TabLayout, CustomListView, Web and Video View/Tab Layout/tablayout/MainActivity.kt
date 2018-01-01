package com.bmpl.tablayout

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.bmpl.tablayout.R.id.tabLayout
import com.bmpl.tablayout.R.id.viewPager
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById(viewPager) as ViewPager

        val tabLayout = findViewById(tabLayout) as TabLayout

        tabLayout.setupWithViewPager(viewPager)
        setUpPages(viewPager)//custom function

    }

    private fun setUpPages(viewPager: ViewPager) {
        var viewPagerAdapter = ViewPagerAdapter(supportFragmentManager) // Fragment Manager
        viewPagerAdapter.add(ContactsFragment(), "Contacts")    //title show
        viewPagerAdapter.add(CallFragment(), "Call")

        viewPager.adapter = viewPagerAdapter
        //var viewPagerAdapter = ViewPagerAdapter(fragmentManager)
    }
    //PagerAdapter --> FragmentPagerAdapter -->
    class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        //var array = arrayOf("", "")

        var fragmentList = ArrayList<Fragment>()
        var titleList = ArrayList<String>()

        fun add(fragment : Fragment, title : String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        //not abstract
        override fun getPageTitle(position: Int): CharSequence {
            return titleList[position]
        }
    }
}

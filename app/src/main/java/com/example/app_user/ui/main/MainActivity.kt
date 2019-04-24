package com.example.app_user.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.app_user.R
import kotlinx.android.synthetic.main.activity_main.*
import com.example.app_user.ui.main.adopt.AdoptFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.app_user.R.layout.activity_main)
        view_main.adapter = PagerAdapter(supportFragmentManager)
        view_main.currentItem = 0
        tab_main.addTab(tab_main.newTab().setText("입양"))
        tab_main.addTab(tab_main.newTab().setText("신고"))
        tab_main.addTab(tab_main.newTab().setText("신청"))
        tab_main.addTab(tab_main.newTab().setText("후기"))
        supportFragmentManager.beginTransaction().replace(R.id.view_main, AdoptFragment()).commit()
        tab_main.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view_main.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        view_main.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_main))

        tab_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                view_main.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }


            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }
}

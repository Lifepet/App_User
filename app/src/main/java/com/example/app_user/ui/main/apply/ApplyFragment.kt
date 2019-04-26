package com.example.app_user.ui.main.apply

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.ApplyAdapter
import com.example.app_user.adapter.DeclarationAdapter
import org.jetbrains.anko.find

class ApplyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.apply_fragment, container, false) as ViewGroup
        val tab_Apply = layout.find<TabLayout>(R.id.tab_apply)
        val view_Apply = layout.find<ViewPager>(R.id.view_apply)
        view_Apply.currentItem = 0
        view_Apply.adapter = ApplyAdapter(childFragmentManager)
        tab_Apply.addTab(tab_Apply.newTab().setText("이동봉사 신청"))
        tab_Apply.addTab(tab_Apply.newTab().setText("임시보호 신청"))
        tab_Apply.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view_Apply.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        view_Apply.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_Apply))

        tab_Apply.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                view_Apply.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }


            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        return layout
    }
}

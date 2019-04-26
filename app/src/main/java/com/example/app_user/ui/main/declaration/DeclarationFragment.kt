package com.example.app_user.ui.main.declaration

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.DeclarationAdapter
import com.example.app_user.ui.main.adopt.AdoptFragment
import com.example.app_user.ui.main.declaration.lost.LostFragment
import org.jetbrains.anko.find

class DeclarationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.declaration_fragment, container, false) as ViewGroup
        val tab_Declaration = layout.find<TabLayout>(R.id.tab_declaratioon)
        val view_Declaration=layout.find<ViewPager>(R.id.view_declaration)
        view_Declaration.currentItem = 0
        view_Declaration.adapter = DeclarationAdapter(childFragmentManager)
        tab_Declaration.addTab(tab_Declaration.newTab().setText("신고"))
        tab_Declaration.addTab(tab_Declaration.newTab().setText("제보"))

        tab_Declaration.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view_Declaration.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        view_Declaration.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_Declaration))

        tab_Declaration.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                view_Declaration.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }


            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        return layout
    }

}

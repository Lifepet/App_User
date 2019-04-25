package com.example.app_user.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.app_user.ui.main.adopt.AdoptFragment
import com.example.app_user.ui.main.apply.ApplyFragment
import com.example.app_user.ui.main.declaration.DeclarationFragment
import com.example.app_user.ui.main.declaration.lost.LostFragment
import com.example.app_user.ui.main.declaration.report.ReportFragment
import com.example.app_user.ui.main.review.ReviewFragment

class DeclarationAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        when (p0) {
            0 -> return LostFragment()
            1 -> return ReportFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

}
package com.example.app_user.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.app_user.ui.main.apply.protect.ProtectFragment
import com.example.app_user.ui.main.apply.volunteer.VolunteerFragment

class ApplyAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        when (p0) {
            0 -> return VolunteerFragment()
            1 -> return ProtectFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

}
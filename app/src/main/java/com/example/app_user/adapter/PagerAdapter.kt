package com.example.app_user.adapter

import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.app_user.ui.main.adopt.AdoptFragment
import com.example.app_user.ui.main.apply.ApplyFragment
import com.example.app_user.ui.main.declaration.DeclarationFragment
import com.example.app_user.ui.main.review.ReviewFragment

class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        when (p0) {
            0 -> return AdoptFragment()
            1 -> return DeclarationFragment()
            2 -> return ApplyFragment()
            3 -> return ReviewFragment()
            else->return null
        }
    }

    override fun getCount(): Int {
        return 4
    }

}
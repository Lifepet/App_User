package com.example.app_user.ui.detail_adopt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.apply_adopt.ApplyAdoptActivity
import kotlinx.android.synthetic.main.activity_detail_adopt.*
import org.jetbrains.anko.startActivity

class AdoptDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_adopt)
        bt_apply.setOnClickListener { startActivity<ApplyAdoptActivity>() }
    }
}

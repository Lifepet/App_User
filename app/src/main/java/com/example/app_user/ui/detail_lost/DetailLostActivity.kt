package com.example.app_user.ui.detail_lost

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app_user.R
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.startActivity

class DetailLostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lost)
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
        text_title.setText("신고")
    }
}
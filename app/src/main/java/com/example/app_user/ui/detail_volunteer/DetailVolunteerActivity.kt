package com.example.app_user.ui.detail_volunteer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail_apply.*
import org.jetbrains.anko.startActivity

class DetailVolunteerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_volunteer)
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
        text_title_apply.setText("이동봉사")
    }
}

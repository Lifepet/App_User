package com.example.app_user.ui.detail_report

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_report)
        text_title.setText("제보")
    }
}

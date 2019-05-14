package com.example.app_user.ui.applyVolunteer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_apply_volunteer.*
import org.jetbrains.anko.startActivity

class ApplyVolunteerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_volunteer)
        bt_complete.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}

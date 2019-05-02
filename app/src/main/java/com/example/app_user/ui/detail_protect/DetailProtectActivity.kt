package com.example.app_user.ui.detail_protect

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.apply_protect.ApplyProtectActivity
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail_apply.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DetailProtectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_protect)
        text_title_apply.text="임시보호"
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
        bt_apply.text="임시보호 신청"
        bt_apply.setOnClickListener { startActivity<ApplyProtectActivity>() }
    }
}

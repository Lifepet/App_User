package com.example.app_user.ui.apply_adopt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_apply_adopt.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ApplyAdoptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_adopt)
        bt_complete.setOnClickListener {
            startActivity<MainActivity>()
            toast("작성이 완료되었습니다.")
        }
    }
}

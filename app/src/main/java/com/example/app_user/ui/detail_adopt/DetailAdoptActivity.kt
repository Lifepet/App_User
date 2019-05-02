package com.example.app_user.ui.detail_adopt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.apply_adopt.ApplyAdoptActivity
import com.example.app_user.ui.dialog_comment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail_apply.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DetailAdoptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_adopt)
        text_title_apply.setText("입양")
        bt_apply.setOnClickListener { startActivity<ApplyAdoptActivity>() }
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
        ic_comment.setOnClickListener {
            val commentDialog = CommentDialog(this)
            commentDialog.Comment()
            commentDialog.type="입양"
        }
    }
}

package com.example.app_user.ui.detail_volunteer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.apply_volunteer.ApplyVolunteerActivity
import com.example.app_user.ui.dialog_comment.CommentDialog
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
        ic_comment.setOnClickListener {
            val commentDialog = CommentDialog(this)
            commentDialog.Comment()
            commentDialog.type="이동봉사"
        }
        text_title_apply.text="이동봉사"
        bt_apply.text="이동봉사 신청"
        bt_apply.setOnClickListener { startActivity<ApplyVolunteerActivity>() }
    }
}

package com.example.app_user.ui.detail_review

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.dialog_comment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.startActivity

class DetailReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_review)
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
        ic_comment.setOnClickListener {
            val commentDialog = CommentDialog(this)
            commentDialog.Comment()
            commentDialog.type="후기"
        }
        text_title.text="후기"
    }
}

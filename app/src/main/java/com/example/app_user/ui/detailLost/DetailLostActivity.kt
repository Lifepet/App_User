package com.example.app_user.ui.detailLost

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app_user.R
import com.example.app_user.ui.dialogComment.CommentDialog
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
        ic_comment.setOnClickListener {
            val commentDialog = CommentDialog(this)
            commentDialog.Comment()
            commentDialog.type="신고"
        }
        text_title.setText("신고")
    }
}
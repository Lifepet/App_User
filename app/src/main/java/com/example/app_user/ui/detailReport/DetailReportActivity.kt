package com.example.app_user.ui.detailReport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.dialogComment.CommentDialog
import kotlinx.android.synthetic.main.activity_detail.*

class DetailReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_report)
        text_title.setText("제보")
        ic_comment.setOnClickListener {
            val commentDialog = CommentDialog(this)
            commentDialog.Comment()
            commentDialog.type="제보"
        }
    }
}

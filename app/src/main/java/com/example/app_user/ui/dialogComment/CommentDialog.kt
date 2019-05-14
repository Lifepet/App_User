package com.example.app_user.ui.dialogComment

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Toast
import com.example.app_user.R
import kotlinx.android.synthetic.main.dialog_comment.*

class CommentDialog(internal var context: Context) {
    var type:String = ""
    fun Comment() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_comment)
        dialog.show()
        dialog.bt_complete.setOnClickListener { Toast.makeText(context,type,Toast.LENGTH_SHORT).show() }
    }
}

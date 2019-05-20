package com.example.app_user.ui.detailLost

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailLostBinding
import com.example.app_user.databinding.ActivityDetailProtectBinding
import com.example.app_user.ui.detail_adopt.DetailAdoptViewModel
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.startActivity

class DetailLostActivity : DataBindingActivity<ActivityDetailLostBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_lost

    private val viewModel: DetailLostViewModel by lazy {
        ViewModelProviders.of(this).get(DetailLostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm=viewModel
        val intent=intent
        viewModel.postId.value=intent.getStringExtra("id")
        viewModel.getLostDetail()
    }
}
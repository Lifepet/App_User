package com.example.app_user.ui.detailProtect

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailProtectBinding
import com.example.app_user.ui.detail_adopt.DetailAdoptViewModel
import com.example.app_user.util.DataBindingActivity

class DetailProtectActivity : DataBindingActivity<ActivityDetailProtectBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_protect

    private val viewModel: DetailProtectViewModel by lazy {
        ViewModelProviders.of(this).get(DetailProtectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.getProtectDetail()
    }
}

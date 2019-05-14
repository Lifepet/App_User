package com.example.app_user.ui.detail_adopt

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailAdoptBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class DetailAdoptActivity : DataBindingActivity<ActivityDetailAdoptBinding>() {
    override val layoutId: Int get() = R.layout.activity_detail_adopt

    private val viewModel: DetailAdoptViewModel by lazy {
        ViewModelProviders.of(this).get(DetailAdoptViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent=intent
        viewModel.postId.value= intent.getStringExtra("id")
        viewModel.getAdoptDetail()
        viewModel.backMain.observe(this, Observer { startActivity<MainActivity>() })
    }
}

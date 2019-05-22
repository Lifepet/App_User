package com.example.app_user.ui.applyAdopt

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityApplyAdoptBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class ApplyAdoptActivity : DataBindingActivity<ActivityApplyAdoptBinding>() {
    override val layoutId: Int get() = R.layout.activity_apply_adopt

    private val viewModel: ApplyAdoptViewModel by lazy {
        ViewModelProviders.of(this).get(ApplyAdoptViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.adoptApply.observe(this, Observer { startActivity<MainActivity>() })
    }
}

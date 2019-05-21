package com.example.app_user.ui.applyProtect

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityApplyProtectBinding
import com.example.app_user.ui.applyAdopt.ApplyAdoptViewModel
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_apply_protect.*
import org.jetbrains.anko.startActivity

class ApplyProtectActivity : DataBindingActivity<ActivityApplyProtectBinding>() {

    override val layoutId: Int get() = R.layout.activity_apply_protect

    private val viewModel: ApplyProtectViewModel by lazy {
        ViewModelProviders.of(this).get(ApplyProtectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent=intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.protectApply.observe(this, Observer { startActivity<MainActivity>() })
    }
}

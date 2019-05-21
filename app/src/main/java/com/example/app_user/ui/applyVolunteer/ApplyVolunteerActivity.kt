package com.example.app_user.ui.applyVolunteer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityApplyVolunteerBinding
import com.example.app_user.ui.applyProtect.ApplyProtectViewModel
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_apply_volunteer.*
import org.jetbrains.anko.startActivity

class ApplyVolunteerActivity : DataBindingActivity<ActivityApplyVolunteerBinding>(){

    override val layoutId: Int get() = R.layout.activity_apply_volunteer

    private val viewModel: ApplyVolunteerViewModel by lazy {
        ViewModelProviders.of(this).get(ApplyVolunteerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent=intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.volunteerApply.observe(this, Observer { startActivity<MainActivity>() })
    }
}

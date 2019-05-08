package com.example.app_user.ui.signup

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivitySignupBinding
import com.example.app_user.ui.login.LoginActivity
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class SignupActivity : DataBindingActivity<ActivitySignupBinding>() {
    override val layoutId: Int get() = R.layout.activity_signup

    private val viewModel: SignupViewModel by lazy { ViewModelProviders.of(this).get(SignupViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        viewModel.signupEvent.observe(this, Observer { startActivity<LoginActivity>() })
    }
}

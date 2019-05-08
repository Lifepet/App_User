package com.example.app_user.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityLoginBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.ui.signup.SignupActivity
import com.example.app_user.ui.signup.SignupViewModel
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class LoginActivity : DataBindingActivity<ActivityLoginBinding>() {

    override val layoutId: Int get() = R.layout.activity_login

    private val viewModel: LoginViewModel by lazy { ViewModelProviders.of(this).get(LoginViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm=viewModel
    }
}

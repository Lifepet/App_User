package com.example.app_user.ui.login

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.ui.signup.SignupActivity
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), LoginNavigator {
    override fun intentSignup() {
        startActivity<SignupActivity>()
    }

    override fun intentLogin() {
        startActivity<MainActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<com.example.app_user.databinding.ActivityLoginBinding>(this, R.layout.activity_login)
        binding.vm= LoginViewModel(this)
    }
}
package com.example.app_user.ui.signup

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivitySignupBinding
import com.example.app_user.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SignupActivity : AppCompatActivity(),SignupNavigator{
    override fun intentMain() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignupBinding>(this, R.layout.activity_signup)
        binding.vm = SignupViewModel(this)
    }
}

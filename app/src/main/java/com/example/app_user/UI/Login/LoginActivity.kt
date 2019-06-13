package com.example.app_user.ui.login

import android.app.Activity
import android.arch.lifecycle.Observer
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
import com.example.app_user.util.getToken
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : DataBindingActivity<ActivityLoginBinding>() {
    override val layoutId: Int get() = R.layout.activity_login

    private val viewModel: LoginViewModel by lazy { ViewModelProviders.of(this).get(LoginViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        viewModel.touchLogin.observe(this, Observer {
            startActivity<MainActivity>()
            finish()
        })
        viewModel.touchSignup.observe(this, Observer { startActivity<SignupActivity>() })
        viewModel.touchError.observe(this, Observer { toast("아이디 혹은 비밀번호가 틀렸습니다.") })
        viewModel.touchNull.observe(this, Observer { toast("아이디 혹은 비밀번호를 입력하지 않으셨습니다.") })
    }
}

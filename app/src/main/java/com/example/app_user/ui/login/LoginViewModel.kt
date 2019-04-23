package com.example.app_user.ui.login

import android.arch.lifecycle.ViewModel

class LoginViewModel(val loginNavigator: LoginNavigator): ViewModel() {
    fun login_Touch(){loginNavigator.intentLogin()}
    fun signup_Touch(){loginNavigator.intentSignup()}
}
package com.example.app_user.ui.login

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast

class LoginViewModel(val loginNavigator: LoginNavigator) : ViewModel() {
    val edit_Id = ObservableField<String>("")
    val edit_Password = ObservableField<String>("")
    fun login_Touch(view: View) {
        if (edit_Id.get().toString().length == 0 || edit_Password.get().toString().length == 0) {
            Toast.makeText(view.context, "입력이 바르지 않습니다.", Toast.LENGTH_SHORT).show()
        } else {
            loginNavigator.intentLogin()
        }
    }
    fun signup_Touch() {
        loginNavigator.intentSignup()
    }
}
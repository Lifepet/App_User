package com.example.app_user.ui.detail_adopt

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailAdoptBinding
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DetailAdoptActivity : DataBindingActivity<ActivityDetailAdoptBinding>() {
    override val layoutId: Int get() = R.layout.activity_detail_adopt

    private val viewModel: DetailAdoptViewModel by lazy {
        ViewModelProviders.of(this).get(DetailAdoptViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent=intent
        viewModel.postId.value= intent.getStringExtra("id")
        viewModel.getAdoptDetail()
    }
}

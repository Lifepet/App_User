package com.example.app_user.ui.writeReview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityWriteReviewBinding
import com.example.app_user.ui.detailProtect.DetailProtectViewModel
import com.example.app_user.util.DataBindingActivity
import android.provider.MediaStore
import android.content.Intent
import android.database.Cursor
import android.media.Image
import android.widget.ImageView
import org.jetbrains.anko.find
import java.io.File
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import com.example.app_user.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_write_review.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class WriteReviewActivity : DataBindingActivity<ActivityWriteReviewBinding>() {

    override val layoutId: Int get() = R.layout.activity_write_review

    private val viewModel: WriteReviewViewModel by lazy {
        ViewModelProviders.of(this).get(WriteReviewViewModel::class.java)
    }

    private val PICK_FROM_ALBUM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        viewModel.getImage.observe(this, Observer {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(intent, PICK_FROM_ALBUM)
        })
        viewModel.successPost.observe(this, Observer {
            startActivity<MainActivity>("position" to 3)
            toast("성공")
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == PICK_FROM_ALBUM) {
            val photoUri = data!!.data
            var cursor: Cursor? = null
            try {
                val proj = arrayOf(MediaStore.Images.Media.DATA)
                assert(photoUri != null)
                cursor = contentResolver.query(photoUri!!, proj, null, null, null)
                assert(cursor != null)
                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor.moveToFirst()
                viewModel.imageUri.value = File(cursor.getString(column_index))

            } finally {
                if (cursor != null) {
                    cursor.close()
                }
            }
            Log.d("test", viewModel.imageUri.value.toString())
            setImage()

        }
    }

    fun setImage() {
        val imageMain = find<ImageView>(R.id.imageView4)
        val options = BitmapFactory.Options()
        ic_image.visibility = View.INVISIBLE
        val originalBm = BitmapFactory.decodeFile(viewModel.imageUri.value?.getAbsolutePath(), options)
        imageMain.setImageBitmap(originalBm)

    }
}
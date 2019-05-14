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


class WriteReviewActivity : DataBindingActivity<ActivityWriteReviewBinding>() {
    override val layoutId: Int get() = R.layout.activity_write_review

    private val viewModel: WriteReviewViewModel by lazy {
        ViewModelProviders.of(this).get(WriteReviewViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        viewModel.getImage.observe(this, Observer {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(intent, 1)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1) {
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
            setImage()

        }
    }

    fun setImage() {
        val imageMain = find<ImageView>(R.id.imageView4)
        val options = BitmapFactory.Options()
        val originalBm = BitmapFactory.decodeFile(viewModel.imageUri.value?.getAbsolutePath(), options)
        imageMain.setImageBitmap(originalBm)

    }
}
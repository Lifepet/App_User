package com.example.app_user.ui.writeLost

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.database.Cursor
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import com.example.app_user.R
import com.example.app_user.databinding.ActivityLostWriteBinding
import com.example.app_user.databinding.ActivityWriteReviewBinding
import com.example.app_user.ui.writeReview.WriteReviewViewModel
import com.example.app_user.util.DataBindingActivity
import org.jetbrains.anko.find
import java.io.File

class LostWriteActivity : DataBindingActivity<ActivityLostWriteBinding>() {

    override val layoutId: Int get() = R.layout.activity_lost_write

    private val viewModel: LostWriteViewModel by lazy {
        ViewModelProviders.of(this).get(LostWriteViewModel::class.java)
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
        val imageMain = find<ImageView>(R.id.lost_image_ic)
        val options = BitmapFactory.Options()
        val originalBm = BitmapFactory.decodeFile(viewModel.imageUri.value?.getAbsolutePath(), options)
        imageMain.setImageBitmap(originalBm)

    }
}

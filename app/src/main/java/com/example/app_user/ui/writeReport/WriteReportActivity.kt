package com.example.app_user.ui.writeReport

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.database.Cursor
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.app_user.R
import com.example.app_user.databinding.ActivityWriteReportBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.ui.writeLost.LostWriteViewModel
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_write_report.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.io.File

class WriteReportActivity : DataBindingActivity<ActivityWriteReportBinding>() {

    override val layoutId: Int get() = R.layout.activity_write_report

    private val viewModel: WriteReportViewModel by lazy {
        ViewModelProviders.of(this).get(WriteReportViewModel::class.java)
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
        viewModel.gotoMain.observe(this, Observer { startActivity<MainActivity>() })
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
        val imageMain = find<ImageView>(R.id.report_image_ic)
        ic_image.visibility = View.INVISIBLE
        val options = BitmapFactory.Options()
        val originalBm = BitmapFactory.decodeFile(viewModel.imageUri.value?.getAbsolutePath(), options)
        imageMain.setImageBitmap(originalBm)

    }
}

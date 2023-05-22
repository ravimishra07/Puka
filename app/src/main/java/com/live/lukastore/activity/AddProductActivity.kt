package com.live.lukastore.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivityAddProductBinding
import com.live.lukastore.util.hide
import com.live.lukastore.util.show

class AddProductActivity : BaseActivity() {
    private lateinit var binding: ActivityAddProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isEdit = intent?.extras?.getBoolean("isEdit") ?: false
        binding.tb.customToolbar.show()
        binding.tb.toolbarTitle.text = if (isEdit) "Edit Product" else "Add Product"
        setListeners()
    }

    private fun setListeners(){
        binding.apply {
            cvUpload.setOnClickListener{
                openImageSelector()
            }
            tb.backButton.setOnClickListener{
                finish()
            }
        }
    }
    private val imageResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK && result.data != null) {
            val uri = result.data!!.data

            binding.selectedImage.setImageURI(uri)
        }
    }

    fun openImageSelector() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PICK_IMAGE_REQUEST)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PICK_IMAGE_REQUEST && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // The permission was granted, so we can start the activity to select the image.
            imageResultLauncher.launch(intent)
        } else {
            // The permission was denied, so we can't start the activity to select the image.
        }
    }
    companion object {
          private val PICK_IMAGE_REQUEST = 1
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, AddProductActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}
package com.live.lukastore.activity

import android.os.Bundle
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivityAddProductBinding

class AddProductActivity : BaseActivity() {
    private lateinit var binding: ActivityAddProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isEdit = intent?.extras?.getBoolean("isEdit") ?: false
        parentBinding.tb.customToolbar.title = if (isEdit) "Edit Product" else "Add Product"
    }

    private fun setListeners(){
        binding.apply {
            cvUpload.setOnClickListener{

            }
        }
    }
}
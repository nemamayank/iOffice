package com.assignment.ui.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.assignment.R
import com.assignment.databinding.ImageDetailBinding
import com.assignment.ui.viewmodel.DetailViewModel
import com.assignment.utility.Constants.IMAGE_DETAIL_URL
import com.bumptech.glide.Glide

class ImageDetailScreen : AppCompatActivity() {
    private lateinit var binding: ImageDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ImageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val image = intent.extras!!.getString(IMAGE_DETAIL_URL)
        Glide.with(this)
            .load(image)
            .error(R.drawable.ic_error)
            .into(binding.detailImage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
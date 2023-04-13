package com.andresaftari.foodiezz.ui.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresaftari.foodiezz.R
import com.andresaftari.foodiezz.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
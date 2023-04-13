package com.andresaftari.foodiezz.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.andresaftari.foodiezz.MainActivity
import com.andresaftari.foodiezz.R
import com.andresaftari.foodiezz.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(1500)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } catch (e: Exception) {
                    Log.i(
                        "SplashScreen",
                        "Failed! ${e.message} --- ${e.printStackTrace()}"
                    )
                }
            }
        }
        background.start()
    }
}
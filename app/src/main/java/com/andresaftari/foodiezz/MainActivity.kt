package com.andresaftari.foodiezz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.andresaftari.foodiezz.databinding.ActivityMainBinding
import com.andresaftari.foodiezz.ui.view.about.AboutFragment
import com.andresaftari.foodiezz.ui.view.favs.FavoriteFragment
import com.andresaftari.foodiezz.ui.view.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentId: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.apply {
            itemIconTintList = null
            setOnItemSelectedListener { item ->
                val fragments = fun(id: Int, fragment: Fragment) {
                    if (currentId != id) supportFragmentManager.commit {
                        replace(R.id.fragment_container, fragment)
                    }
                }

                when (item.itemId) {
                    R.id.action_home -> fragments(R.id.action_home, HomeFragment())
                    R.id.action_favorite -> fragments(R.id.action_favorite, FavoriteFragment())
                    R.id.action_about -> fragments(R.id.action_about, AboutFragment())
                    else -> fragments(R.id.action_home, HomeFragment())
                }

                currentId = item.itemId
                true
            }
        }

        supportFragmentManager.commit { replace(R.id.fragment_container, HomeFragment()) }
    }
}
package com.andresaftari.foodiezz.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andresaftari.foodiezz.core.domain.model.Category
import com.andresaftari.foodiezz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var listCategory = ArrayList<Category>()
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
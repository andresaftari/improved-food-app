package com.andresaftari.foodiezz.view.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andresaftari.core.adapter.ReusableAdapter
import com.andresaftari.core.domain.model.Category
import com.andresaftari.foodiezz.R
import com.andresaftari.foodiezz.view.detail.DetailActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {
    private val listFavorite = ArrayList<Category>()
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val favoriteAdapter = ReusableAdapter(
                R.layout.item_list,
                listFavorite,
                { itemView, category ->
                    Glide.with(itemView.context)
                        .load(category.strCategoryThumb)
                        .into(itemView.iv_categoryThumb)

                    itemView.tv_categoryName?.text = category.strCategory
                },
                { _, selectedCategory ->
                    startActivity(
                        Intent(
                            requireContext(),
                            DetailActivity::class.java
                        ).putExtra(DetailActivity.EXTRA_CATEGORY, selectedCategory)
                    )
                }
            )

            favoriteViewModel.getFavoriteList.observe(viewLifecycleOwner, { categories ->
                favoriteAdapter.setData(categories)
                view_empty.visibility = if (categories.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_favorite) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = favoriteAdapter
                setHasFixedSize(true)
            }
        }
    }
}
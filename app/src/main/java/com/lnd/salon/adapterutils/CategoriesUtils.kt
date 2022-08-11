package com.lnd.salon.adapterutils

import androidx.recyclerview.widget.DiffUtil
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModelItem

class CategoriesUtils : DiffUtil.ItemCallback<CategoriesResponseModelItem>() {
    override fun areItemsTheSame(
        oldItem: CategoriesResponseModelItem,
        newItem: CategoriesResponseModelItem
    ): Boolean {
        return oldItem.catId == newItem.catId
    }

    override fun areContentsTheSame(
        oldItem: CategoriesResponseModelItem,
        newItem: CategoriesResponseModelItem
    ): Boolean {
        return oldItem.catId == newItem.catId
    }

}
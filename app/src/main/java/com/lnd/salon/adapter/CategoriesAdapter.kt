package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lnd.salon.R
import com.lnd.salon.adapterutils.CategoriesUtils
import com.lnd.salon.presentation.ApplicationClass
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModelItem

class CategoriesAdapter(requireContext: Context) :
    ListAdapter<CategoriesResponseModelItem, CategoriesAdapter.ViewHolder>(CategoriesUtils()) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cat_image: ImageView = itemView.findViewById(R.id.cat_image)
        val cat_name: TextView = itemView.findViewById(R.id.cat_name)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = getItem(position)
        holder.cat_name.text = listItem.categoryName
        val media = listItem.catImg
        if (media != null) {
            ApplicationClass.mInstance?.let {
                Glide.with(it)
                    .load(media)
                    .into(holder.cat_image)
            }
        } else {
            holder.cat_image.setImageResource(R.drawable.ic_launcher_foreground)
        }

    }

    fun setData(list: List<CategoriesResponseModelItem>) {
        submitList(list)
        notifyDataSetChanged()
    }
}
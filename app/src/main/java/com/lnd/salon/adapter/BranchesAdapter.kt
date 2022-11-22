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
import com.lnd.salon.adapterutils.BranchesUtils
import com.lnd.salon.presentation.ApplicationClass
import com.lnd.salon.presentation.models.Branches.BranchesResponseModelItem

class BranchesAdapter(requireContext: Context) :
    ListAdapter<BranchesResponseModelItem, BranchesAdapter.ViewHolder>(BranchesUtils()) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val im_shop_item: ImageView = itemView.findViewById(R.id.im_shop_item)
        val tv_shop_name: TextView = itemView.findViewById(R.id.tv_shop_name)
        val tv_address: TextView = itemView.findViewById(R.id.tv_address)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.branches_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = getItem(position)
        holder.tv_shop_name.text = listItem.branchName
        holder.tv_address.text = listItem.branchAddress
        val media = listItem.branchImg
        if (media != null) {
            ApplicationClass.mInstance?.let {
                Glide.with(it)
                    .load(media)
                    .override(128,128)
                    .into(holder.im_shop_item)
            }
        } else {
            holder.im_shop_item.setImageResource(R.drawable.ic_launcher_foreground)
        }

    }



    fun setData(list: List<BranchesResponseModelItem>) {
        submitList(list)
        notifyDataSetChanged()
    }
}
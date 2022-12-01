package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R
import com.lnd.salon.adapterutils.SaloonPackageUtils
import com.lnd.salon.presentation.models.SaloonDetails.Package

class SaloonPackagesAdapter(var context: Context,var clickListener: ItemClickListener):ListAdapter<Package,SaloonPackagesAdapter.ViewHolder>(SaloonPackageUtils()) {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tv_package_name = itemView.findViewById<TextView>(R.id.tv_package_name)
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int, saloonId: Int)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.package_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_package_name.text = getItem(position).packageName
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(it, position,getItem(position).packageId)
        }
    }

    fun setData(data: List<Package>) {
        submitList(data)
        notifyDataSetChanged()
    }
}
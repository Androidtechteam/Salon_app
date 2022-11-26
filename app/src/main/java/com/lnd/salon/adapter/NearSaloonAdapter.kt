package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R
import com.lnd.salon.adapterutils.NearSaloonUtils
import com.lnd.salon.presentation.models.NearSaloons.Data

class NearSaloonAdapter(context: Context,var clickListener: ItemClickListener) : ListAdapter<Data,NearSaloonAdapter.ViewHolder>(
    NearSaloonUtils()) {

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int, saloonId: Int)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val tv_shop_name = itemView.findViewById<TextView>(R.id.tv_shop_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.near_saloon_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_shop_name.text = getItem(position).name
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(it, position,getItem(position).saloonId)
        }
    }

    fun setData(data: List<Data>) {
        submitList(data)
        notifyDataSetChanged()
    }
}
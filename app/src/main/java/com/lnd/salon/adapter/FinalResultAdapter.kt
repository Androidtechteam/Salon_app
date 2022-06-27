package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R

class FinalResultAdapter(context: Context, val list: Array<String>, var clickListener: ItemClickListener) : RecyclerView.Adapter<FinalResultAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    private val inflater: LayoutInflater
    init {
        inflater = LayoutInflater.from(context)
    }

    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val tv_shop_name = item.findViewById<TextView>(R.id.tv_shop_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.final_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_shop_name.text = list[position]
        holder.itemView.setOnClickListener{
            clickListener.onItemClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R

class SalonServiceAdapter(
    context: Context,
    val list: Array<String>,
    var clickListener: ItemClickListener
) : RecyclerView.Adapter<SalonServiceAdapter.Viewholder>() {

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    class Viewholder(item: View) : RecyclerView.ViewHolder(item) {
        val tv_name = item.findViewById<TextView>(R.id.tv_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = inflater.inflate(R.layout.text_view, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.tv_name.text = list[position]
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
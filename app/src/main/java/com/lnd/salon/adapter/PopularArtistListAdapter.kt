package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R

class PopularArtistListAdapter(val context: Context, val popular_list: Array<String>,var clickListener: ItemClickListener) : RecyclerView.Adapter<PopularArtistListAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)


    class ViewHolder(item:View): RecyclerView.ViewHolder(item) {
        val im_view = item.findViewById<ImageView>(R.id.im_view)
        val tv_name = item.findViewById<TextView>(R.id.tv_name)
        val tv_profession = item.findViewById<TextView>(R.id.tv_profession)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.popular_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = popular_list[position]
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return popular_list.size
    }
}
package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R
import com.lnd.salon.adapterutils.SaloonDetailsUtils
import com.lnd.salon.presentation.models.SaloonDetails.Emlpoyee

class SaloonDetailsAdapter(context: Context, var clickListener: ItemClickListener) :
    ListAdapter<Emlpoyee, SaloonDetailsAdapter.ViewHodel>(SaloonDetailsUtils()) {
    class ViewHodel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emp_image = itemView.findViewById<ImageView>(R.id.emp_image)
        val emp_name = itemView.findViewById<TextView>(R.id.emp_name)
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodel {
        val view = inflater.inflate(R.layout.emp_view, parent, false)
        return ViewHodel(view)
    }

    override fun onBindViewHolder(holder: ViewHodel, position: Int) {
        holder.emp_name.text = getItem(position).employeeName
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(it, position)
        }
    }

    fun setData(data: List<Emlpoyee>) {
        submitList(data)
        notifyDataSetChanged()
    }
}
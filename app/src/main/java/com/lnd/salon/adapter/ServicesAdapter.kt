package com.lnd.salon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.lnd.salon.R
import com.lnd.salon.presentation.ui.DashBoardFragmentDirections

class ServicesAdapter(requireContext: Context, val myImageNameList: Array<String>) :
    RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(requireContext)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image =  itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.service_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setOnClickListener{
            val action = DashBoardFragmentDirections.actionDashboardScreenToYourAppointment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return myImageNameList.size
    }
}
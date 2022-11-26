package com.lnd.salon.adapterutils

import androidx.recyclerview.widget.DiffUtil
import com.lnd.salon.presentation.models.SaloonDetails.Emlpoyee

class SaloonDetailsUtils : DiffUtil.ItemCallback<Emlpoyee>() {
    override fun areItemsTheSame(
        oldItem: Emlpoyee,
        newItem: Emlpoyee
    ): Boolean {
        return oldItem.employeeId == newItem.employeeId
    }

    override fun areContentsTheSame(
        oldItem: Emlpoyee,
        newItem: Emlpoyee
    ): Boolean {
        return oldItem.employeeId == newItem.employeeId
    }
}
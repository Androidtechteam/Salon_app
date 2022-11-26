package com.lnd.salon.adapterutils

import androidx.recyclerview.widget.DiffUtil
import com.lnd.salon.presentation.models.NearSaloons.Data

class NearSaloonUtils: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem.saloonId == newItem.saloonId
    }

    override fun areContentsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem.saloonId == newItem.saloonId
    }
}
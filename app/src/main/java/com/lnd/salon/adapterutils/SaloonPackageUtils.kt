package com.lnd.salon.adapterutils

import androidx.recyclerview.widget.DiffUtil
import com.lnd.salon.presentation.models.NearSaloons.Data
import com.lnd.salon.presentation.models.SaloonDetails.Package

class SaloonPackageUtils: DiffUtil.ItemCallback<Package>() {
    override fun areItemsTheSame(
        oldItem: Package,
        newItem: Package
    ): Boolean {
        return oldItem.packageId == newItem.packageId
    }

    override fun areContentsTheSame(
        oldItem: Package,
        newItem: Package
    ): Boolean {
        return oldItem.packageId == newItem.packageId
    }
}
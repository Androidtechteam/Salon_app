package com.lnd.salon.adapterutils

import androidx.recyclerview.widget.DiffUtil
import com.lnd.salon.presentation.models.Branches.BranchesResponseModelItem

class BranchesUtils : DiffUtil.ItemCallback<BranchesResponseModelItem>() {
    override fun areItemsTheSame(
        oldItem: BranchesResponseModelItem,
        newItem: BranchesResponseModelItem
    ): Boolean {
        return oldItem.branchId == newItem.branchId
    }

    override fun areContentsTheSame(
        oldItem: BranchesResponseModelItem,
        newItem: BranchesResponseModelItem
    ): Boolean {
        return oldItem.branchId == newItem.branchId
    }

}
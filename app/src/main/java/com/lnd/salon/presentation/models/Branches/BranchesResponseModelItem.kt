package com.lnd.salon.presentation.models.Branches


import com.google.gson.annotations.SerializedName

data class BranchesResponseModelItem(
    @SerializedName("branchAddress")
    var branchAddress: String,
    @SerializedName("branchArea")
    var branchArea: String,
    @SerializedName("branchContactNumber")
    var branchContactNumber: String,
    @SerializedName("branchId")
    var branchId: Int,
    @SerializedName("branchLocation")
    var branchLocation: String,
    @SerializedName("branchName")
    var branchName: String,
    @SerializedName("branchParentId")
    var branchParentId: Int,
    @SerializedName("creationDate")
    var creationDate: Any,
    @SerializedName("lastModifiedDate")
    var lastModifiedDate: Any,
    @SerializedName("recStatus")
    var recStatus: Any
)
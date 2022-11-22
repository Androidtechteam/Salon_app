package com.lnd.salon.presentation.models.Categories


import com.google.gson.annotations.SerializedName
import com.lnd.salon.presentation.models.Branches.BranchesResponseModelItem
import com.squareup.moshi.Json

data class CategoriesResponseModel(
    @Json(name = "data")
    var `data`: List<CategoriesResponseModelItem>,
    @Json(name = "message")
    var message: String,
    @Json(name = "status")
    var status: Int
)
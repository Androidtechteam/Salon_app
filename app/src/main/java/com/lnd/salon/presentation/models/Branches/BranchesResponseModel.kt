package com.lnd.salon.presentation.models.Branches


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class BranchesResponseModel(
    @Json(name = "data")
    var `data`: List<BranchesResponseModelItem>,
    @Json(name = "message")
    var message: String,
    @Json(name = "status")
    var status: Int
)
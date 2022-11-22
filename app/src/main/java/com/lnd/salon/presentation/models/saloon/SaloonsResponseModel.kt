package com.lnd.salon.presentation.models.saloon


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class SaloonsResponseModel(
    @Json(name = "data")
    var `data`: List<SaloonsResponseModelItem>,
    @Json(name = "message")
    var message: String,
    @Json(name = "status")
    var status: Int
)
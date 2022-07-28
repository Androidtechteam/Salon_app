package com.lnd.salon.presentation.models.BeautyTips


import com.google.gson.annotations.SerializedName

data class BeautyTipsResponseModelItem(
    @SerializedName("recStatus")
    var recStatus: Int,
    @SerializedName("tipCategory")
    var tipCategory: String,
    @SerializedName("tipDescription")
    var tipDescription: String,
    @SerializedName("tipId")
    var tipId: Int,
    @SerializedName("tipImg")
    var tipImg: Any,
    @SerializedName("tipTitle")
    var tipTitle: String,
    @SerializedName("tipVideo")
    var tipVideo: Any
)
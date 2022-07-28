package com.lnd.salon.presentation.models.Coupons


import com.google.gson.annotations.SerializedName

data class CouponsResponseModelItem(
    @SerializedName("couponCode")
    var couponCode: String,
    @SerializedName("couponDescription")
    var couponDescription: String,
    @SerializedName("couponDiscount")
    var couponDiscount: String,
    @SerializedName("couponId")
    var couponId: Int,
    @SerializedName("couponImg")
    var couponImg: Any,
    @SerializedName("couponName")
    var couponName: String,
    @SerializedName("expiryDate")
    var expiryDate: String,
    @SerializedName("modifiedDate")
    var modifiedDate: Any,
    @SerializedName("recStatus")
    var recStatus: Int
)
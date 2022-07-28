package com.lnd.salon.presentation.models.Categories


import com.google.gson.annotations.SerializedName

data class CategoriesResponseModelItem(
    @SerializedName("catGuid")
    var catGuid: String,
    @SerializedName("catId")
    var catId: Int,
    @SerializedName("catImg")
    var catImg: Any,
    @SerializedName("categoryName")
    var categoryName: String,
    @SerializedName("createdDate")
    var createdDate: Any,
    @SerializedName("modifiedDate")
    var modifiedDate: Any,
    @SerializedName("recStatus")
    var recStatus: Int
)
package com.lnd.salon.presentation.models.Categories


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class CategoriesResponseModelItem(
    @Json(name = "catGuid")
    var catGuid: String,
    @Json(name = "catId")
    var catId: Int,
    @Json(name = "catImg")
    var catImg: String,
    @Json(name = "categoryName")
    var categoryName: String,
    @Json(name = "contentType")
    var contentType: String,
    @Json(name = "createdBy")
    var createdBy: String,
    @Json(name = "creationDate")
    var creationDate: String,
    @Json(name = "encodedImage")
    var encodedImage: Any,
    @Json(name = "imageName")
    var imageName: String,
    @Json(name = "lastModifiedBy")
    var lastModifiedBy: String,
    @Json(name = "lastModifiedDate")
    var lastModifiedDate: String,
    @Json(name = "recStatus")
    var recStatus: Int
)
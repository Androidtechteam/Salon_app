package com.lnd.salon.presentation.models.Branches


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class BranchesResponseModelItem(
    @Json(name = "branchId")
    var branchId: Int,
    @Json(name = "branchName")
    var branchName: String,
    @Json(name = "branchAddress")
    var branchAddress: String,
    @Json(name = "branchArea")
    var branchArea: String,
    @Json(name = "branchLocation")
    var branchLocation: String,
    @Json(name = "branchContactNumber")
    var branchContactNumber: String,
    @Json(name = "branchParentId")
    var branchParentId: String,
    @Json(name = "branchImg")
    var branchImg: String,
    @Json(name = "imageName")
    var imageName: String,
    @Json(name = "encodedImage")
    var encodedImage: String,
    @Json(name = "contentType")
    var contentType: String,
    @Json(name = "recStatus")
    var recStatus: Int,
    @Json(name = "createdBy")
    var createdBy: String,
    @Json(name = "creationDate")
    var creationDate: String,
    @Json(name = "lastModifiedBy")
    var lastModifiedBy: String,
    @Json(name = "lastModifiedDate")
    var lastModifiedDate: String
)
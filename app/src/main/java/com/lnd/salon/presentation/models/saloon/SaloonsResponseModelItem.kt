package com.lnd.salon.presentation.models.saloon


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class SaloonsResponseModelItem(
    @Json(name = "address1")
    var address1: String,
    @Json(name = "address2")
    var address2: String,
    @Json(name = "bankAccountNumber")
    var bankAccountNumber: Int,
    @Json(name = "bankName")
    var bankName: String,
    @Json(name = "city")
    var city: String,
    @Json(name = "contentType")
    var contentType: String,
    @Json(name = "country")
    var country: String,
    @Json(name = "createdBy")
    var createdBy: String,
    @Json(name = "creationDate")
    var creationDate: String,
    @Json(name = "employees")
    var employees: String,
    @Json(name = "encodedImage")
    var encodedImage: String,
    @Json(name = "gstNum")
    var gstNum: String,
    @Json(name = "havingBranches")
    var havingBranches: Boolean,
    @Json(name = "ifscCode")
    var ifscCode: String,
    @Json(name = "imageName")
    var imageName: String,
    @Json(name = "lastModifiedBy")
    var lastModifiedBy: String,
    @Json(name = "lastModifiedDate")
    var lastModifiedDate: String,
    @Json(name = "lattitude")
    var lattitude: String,
    @Json(name = "longitude")
    var longitude: String,
    @Json(name = "name")
    var name: String,
    @Json(name = "onBoarededDate")
    var onBoarededDate: String,
    @Json(name = "packages")
    var packages: List<Int>,
    @Json(name = "saloonId")
    var saloonId: Int,
    @Json(name = "saloonImg")
    var saloonImg: Any,
    @Json(name = "services")
    var services: List<Int>,
    @Json(name = "state")
    var state: String,
    @Json(name = "status")
    var status: String,
    @Json(name = "tanNumber")
    var tanNumber: String
)
package com.lnd.salon.presentation.models.SaloonDetails

data class Service(
    val contentType: String,
    val createdBy: Any,
    val createdDate: Any,
    val creationDate: String,
    val encodedImage: Any,
    val imageName: String,
    val lastModifiedBy: String,
    val lastModifiedDate: String,
    val modifiedDate: Any,
    val recStatus: Int,
    val serviceDescription: String,
    val serviceDuration: String,
    val serviceId: Int,
    val serviceImg: String,
    val serviceName: String,
    val servicePrice: String,
    val serviceTax: String,
    val serviceVisibility: String,
    val subCatId: Int
)
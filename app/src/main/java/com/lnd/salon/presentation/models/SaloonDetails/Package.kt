package com.lnd.salon.presentation.models.SaloonDetails

data class Package(
    val expiresIn: String,
    val isGlobal: String,
    val packageDescription: Any,
    val packageEndDate: String,
    val packageId: Int,
    val packageName: String,
    val packageOnOtherServices: Any,
    val packagePrice: String,
    val packageServices: Any,
    val packageStartDate: Any,
    val packageType: Any,
    val packageValidityDays: Int,
    val packageVisibility: Any,
    val recStatus: Any
)
package com.lnd.salon.presentation.models.NearSaloons

data class NearBySaloon(
    val `data`: List<Data>,
    val message: String,
    val status: Int
)
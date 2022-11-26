package com.lnd.salon.presentation.models.SaloonDetails

data class Data(
    val emlpoyees: List<Emlpoyee>,
    val packages: List<Package>,
    val saloonDTO: SaloonDTO,
    val services: List<Service>
)
package com.example.core

data class Advertisement(
    val id: AdvertisementId,
    val title: Title,
    val image: Image,
    val description: Description,
    val status: AdvertisementStatus = AdvertisementStatus.PENDING
)

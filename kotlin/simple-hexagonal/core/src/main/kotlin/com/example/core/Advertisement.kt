package com.example.core

data class Advertisement(
    val id: AdvertisementId,
    val title: Title,
    val image: Image,
    val description: Description,
    val status: AdvertisementStatus
) {
    companion object {
        fun new(title: Title, image: Image, description: Description): Advertisement {
            return Advertisement(
                id = AdvertisementId.new(),
                title = title,
                image = image,
                description = description,
                status = AdvertisementStatus.PENDING
            )
        }
    }
}

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
            val id = DistributedId.nextId()
            return Advertisement(
                id = AdvertisementId(id),
                title = title,
                image = image,
                description = description,
                status = AdvertisementStatus.PENDING
            )
        }
    }
}

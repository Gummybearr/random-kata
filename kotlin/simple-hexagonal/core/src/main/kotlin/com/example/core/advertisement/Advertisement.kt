package com.example.core.advertisement

class Advertisement(
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

    fun update(newTitle: Title?, newImage: Image?, newDescription: Description?): Advertisement {
        val title = newTitle?:title
        val image = newImage?:image
        val description = newDescription?:description
        val status = status.updateOnModifyRequest()
        return Advertisement(
            id = id,
            title = title,
            image = image,
            description = description,
            status = status
        )
    }
}

package com.example.domain.advertisement

import com.example.domain.AdvertiserId

class Advertisement(
    val id: AdvertisementId,
    val advertiserId: AdvertiserId,
    val title: Title,
    val image: Image,
    val description: Description
) {
    constructor(
        advertiserId: AdvertiserId,
        title: Title,
        image: Image,
        description: Description
    ) : this(AdvertisementId(), advertiserId, title, image, description)

    fun update(newTitle: Title?, newImage: Image?, newDescription: Description?): Advertisement {
        val title = newTitle ?: title
        val image = newImage ?: image
        val description = newDescription ?: description
        return Advertisement(
            id = id,
            advertiserId = advertiserId,
            title = title,
            image = image,
            description = description,
        )
    }
}

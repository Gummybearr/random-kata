package com.example.core.advertisement

import com.example.core.AdvertiserId

class Advertisement(
    val id: AdvertisementId,
    val advertiserId: AdvertiserId,
    val title: Title,
    val image: Image,
    val description: Description,
    val status: AdvertisementStatus
) {
    constructor(
        advertiserId: AdvertiserId,
        title: Title,
        image: Image,
        description: Description
    ) : this(AdvertisementId(), advertiserId, title, image, description, AdvertisementStatus.PENDING)

    fun update(newTitle: Title?, newImage: Image?, newDescription: Description?): Advertisement {
        val title = newTitle ?: title
        val image = newImage ?: image
        val description = newDescription ?: description
        val status = status.updateOnModifyRequest()
        return Advertisement(
            id = id,
            advertiserId = advertiserId,
            title = title,
            image = image,
            description = description,
            status = status
        )
    }

    fun live(): Advertisement {
        return Advertisement(
            id = id,
            advertiserId = advertiserId,
            title = title,
            image = image,
            description = description,
            status = status.updateOnLiveRequest()
        )
    }

    fun block(): Advertisement {
        return Advertisement(
            id = id,
            advertiserId = advertiserId,
            title = title,
            image = image,
            description = description,
            status = status.updateOnBlockRequest()
        )
    }
}

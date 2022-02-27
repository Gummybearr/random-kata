package com.example.adapter.out.mapper

import com.example.data.entity.Advertisement
import com.example.core.advertisement.Advertisement as CoreAdvertisement

class AdvertisementMapper {
    fun toPersistence(advertisement: CoreAdvertisement): Advertisement {
        return Advertisement(
            id = advertisement.id,
            title = advertisement.title,
            image = advertisement.image,
            description = advertisement.description,
            status = advertisement.status
        )
    }

    fun toApplication(advertisement: Advertisement): CoreAdvertisement {
        return CoreAdvertisement(
            id = advertisement.id,
            title = advertisement.title,
            image = advertisement.image,
            description = advertisement.description,
            status = advertisement.status
        )
    }
}

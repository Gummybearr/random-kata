package com.example.data.entity

import com.example.core.AdvertiserId
import com.example.core.advertisement.*

// Entity
class Advertisement(
    // 저장시 컨버터에 의해 변환된다고 가정!
    val id: AdvertisementId,
    val advertiserId: AdvertiserId,
    val title: Title,
    val image: Image,
    val description: Description
) {
    override fun toString(): String {
        return "Advertisement(id=$id, advertiserId=$advertiserId, title=$title, image=$image, description=$description)"
    }
}
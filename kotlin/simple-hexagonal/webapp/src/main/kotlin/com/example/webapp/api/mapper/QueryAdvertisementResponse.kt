package com.example.webapp.api.mapper

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementStatus

data class QueryAdvertisementResponse(
    val advertisementId: Long,
    val title: String,
    val image: String,
    val description: String,
    val status: AdvertisementStatus
) {
    companion object {
        fun from(advertisement: Advertisement): QueryAdvertisementResponse {
            return QueryAdvertisementResponse(
                advertisementId = advertisement.id.id,
                title = advertisement.title.title,
                image = advertisement.image.url,
                description = advertisement.description.description,
                status = advertisement.status
            )
        }
    }
}

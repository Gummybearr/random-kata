package com.example.webapp.api.mapper

import com.example.core.advertisement.Advertisement
import com.example.core.logger

data class QueryAdvertisementResponse(
    val advertisementId: Long,
    val title: String,
    val image: String,
    val description: String
) {

    companion object {
        private val logger = logger()

        fun from(
            advertisement: Advertisement
        ): QueryAdvertisementResponse {
            logger.info("웹앱 매퍼에서 웹 요청을 광고 조회 요청 유즈케이스의 인풋으로 변경")
            return QueryAdvertisementResponse(
                advertisementId = advertisement.id.id,
                title = advertisement.title.title,
                image = advertisement.image.url,
                description = advertisement.description.description
            )
        }
    }
}

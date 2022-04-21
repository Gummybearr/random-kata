package com.example.persistence.adapter.mapper

import com.example.domain.logger
import com.example.persistence.entity.Advertisement
import com.example.domain.advertisement.Advertisement as CoreAdvertisement

object AdvertisementMapper {

    private val logger = logger()
    fun toPersistence(advertisement: CoreAdvertisement): Advertisement {
        logger.info("어댑터 모듈의 매퍼에서 광고 객체를 데이터베이스 엔티티로 변경")
        return Advertisement(
            id = advertisement.id,
            advertiserId = advertisement.advertiserId,
            title = advertisement.title,
            image = advertisement.image,
            description = advertisement.description
        )
    }

    fun toApplication(advertisement: Advertisement): CoreAdvertisement {
        logger.info("어댑터 모듈의 매퍼에서 데이터베이스 엔티티를 광고 객체로 변경")
        return CoreAdvertisement(
            id = advertisement.id,
            advertiserId = advertisement.advertiserId,
            title = advertisement.title,
            image = advertisement.image,
            description = advertisement.description
        )
    }
}

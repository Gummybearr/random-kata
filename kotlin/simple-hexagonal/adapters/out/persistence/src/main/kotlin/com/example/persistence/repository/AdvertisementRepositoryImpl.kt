package com.example.persistence.repository

import com.example.domain.AdvertiserId
import com.example.domain.advertisement.AdvertisementId
import com.example.persistence.entity.Advertisement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

class AdvertisementRepositoryImpl : AdvertisementRepository {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    private val database = ConcurrentHashMap<AdvertisementId, Advertisement>()

    override fun find(advertisementId: AdvertisementId): Advertisement? {
        return database[advertisementId]
    }

    override fun findByAdvertiserId(advertiserId: AdvertiserId): List<Advertisement> {
        return database.values.filter { it.advertiserId == advertiserId }
    }

    override fun save(advertisement: Advertisement) {
        database[advertisement.id] = advertisement
        logger.info("데이터베이스에 ${advertisement}를 저장")
    }

    override fun delete(advertisementId: AdvertisementId) {
        database.remove(advertisementId)
        logger.info("데이터베이스에서 광고($advertisementId)를 제거")
    }
}

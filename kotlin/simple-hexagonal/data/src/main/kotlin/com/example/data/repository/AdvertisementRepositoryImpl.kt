package com.example.data.repository

import com.example.core.AdvertisementId
import com.example.data.entity.Advertisement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

class AdvertisementRepositoryImpl : AdvertisementRepository {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    private val database = ConcurrentHashMap<AdvertisementId, Advertisement>()

    override fun find(advertisementId: AdvertisementId): Advertisement? {
        return database[advertisementId]
    }

    override fun save(advertisement: Advertisement) {
        database[advertisement.id] = advertisement
        logger.info("데이터베이스에 ${advertisement}를 저장")
    }
}

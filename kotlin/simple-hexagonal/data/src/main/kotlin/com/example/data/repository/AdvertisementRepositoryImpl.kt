package com.example.data.repository

import com.example.core.AdvertisementId
import com.example.data.entity.Advertisement
import java.util.concurrent.ConcurrentHashMap

class AdvertisementRepositoryImpl : AdvertisementRepository {

    private val database = ConcurrentHashMap<AdvertisementId, Advertisement>()

    override fun find(advertisementId: AdvertisementId): Advertisement? {
        return database[advertisementId]
    }

    override fun save(advertisement: Advertisement) {
        database[advertisement.id] = advertisement
    }
}

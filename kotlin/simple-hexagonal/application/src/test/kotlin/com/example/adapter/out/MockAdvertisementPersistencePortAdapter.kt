package com.example.adapter.out

import com.example.domain.advertisement.Advertisement
import com.example.domain.advertisement.AdvertisementId
import com.example.application.port.out.AdvertisementPersistencePort

class MockAdvertisementPersistencePortAdapter : AdvertisementPersistencePort {

    private val map = mutableMapOf<AdvertisementId, Advertisement>()

    override fun find(advertisementId: AdvertisementId): Advertisement? {
        return map[advertisementId]
    }

    override fun save(advertisement: Advertisement) {
        map[advertisement.id] = advertisement
    }

    override fun delete(advertisementId: AdvertisementId) {
        map.remove(advertisementId)
    }

    fun clear() {
        map.clear()
    }
}

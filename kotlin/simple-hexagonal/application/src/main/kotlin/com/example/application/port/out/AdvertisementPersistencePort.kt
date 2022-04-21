package com.example.application.port.out

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementId

interface AdvertisementPersistencePort {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun save(advertisement: Advertisement)
    fun delete(advertisementId: AdvertisementId)
}
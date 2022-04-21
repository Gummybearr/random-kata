package com.example.application.port.out

import com.example.domain.advertisement.Advertisement
import com.example.domain.advertisement.AdvertisementId

interface AdvertisementPersistencePort {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun save(advertisement: Advertisement)
    fun delete(advertisementId: AdvertisementId)
}
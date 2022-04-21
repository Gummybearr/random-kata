package com.example.data.repository

import com.example.core.AdvertiserId
import com.example.core.advertisement.AdvertisementId
import com.example.data.entity.Advertisement

interface AdvertisementRepository {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun findByAdvertiserId(advertiserId: AdvertiserId): List<Advertisement>
    fun save(advertisement: Advertisement)
    fun delete(advertisementId: AdvertisementId)
}
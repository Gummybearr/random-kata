package com.example.persistence.repository

import com.example.domain.AdvertiserId
import com.example.domain.advertisement.AdvertisementId
import com.example.persistence.entity.Advertisement

interface AdvertisementRepository {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun findByAdvertiserId(advertiserId: AdvertiserId): List<Advertisement>
    fun save(advertisement: Advertisement)
    fun delete(advertisementId: AdvertisementId)
}
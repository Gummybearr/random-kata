package com.example.data.repository

import com.example.core.AdvertisementId
import com.example.data.entity.Advertisement

interface AdvertisementRepository {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun save(advertisement: Advertisement)
}
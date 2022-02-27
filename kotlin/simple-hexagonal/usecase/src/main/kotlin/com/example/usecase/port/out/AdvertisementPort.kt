package com.example.usecase.port.out

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementId

interface AdvertisementPort {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun save(advertisement: Advertisement)
}
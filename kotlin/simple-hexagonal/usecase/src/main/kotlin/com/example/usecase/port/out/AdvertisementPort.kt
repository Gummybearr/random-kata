package com.example.usecase.port.out

import com.example.core.Advertisement
import com.example.core.AdvertisementId

interface AdvertisementPort {
    fun find(advertisementId: AdvertisementId): Advertisement?
    fun save(advertisement: Advertisement)
}
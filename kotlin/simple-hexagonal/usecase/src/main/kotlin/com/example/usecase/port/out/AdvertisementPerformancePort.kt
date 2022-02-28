package com.example.usecase.port.out

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.AdvertisementPerformance

interface AdvertisementPerformancePort {
    fun find(advertisementId: AdvertisementId): AdvertisementPerformance?
}

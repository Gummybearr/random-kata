package com.example.adapter.out

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.AdvertisementPerformance
import com.example.usecase.port.out.AdvertisementPerformancePort
import java.math.BigDecimal

class AdvertisementPerformancePortAdapter : AdvertisementPerformancePort {
    override fun find(advertisementId: AdvertisementId): AdvertisementPerformance {
        return AdvertisementPerformance(
            impression = BigDecimal.ZERO,
            click = BigDecimal.ZERO,
            ctr = 0.0,
            like = BigDecimal.ZERO,
            chat = BigDecimal.ZERO
        )
    }
}

package com.example.usecase.adapter.out

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.AdvertisementPerformance
import com.example.core.logger
import com.example.usecase.port.out.AdvertisementPerformancePort
import java.math.BigDecimal

class AdvertisementPerformancePortAdapter : AdvertisementPerformancePort {

    private val logger = logger()

    // 네트워크 요청을 통해서 외부에서 받아온다고 가정
    override fun find(advertisementId: AdvertisementId): AdvertisementPerformance {
        logger.info("광고를 성과를 외부에서 받아서 리턴")
        return AdvertisementPerformance(
            impression = BigDecimal.ZERO,
            click = BigDecimal.ZERO,
            ctr = 0.0,
            like = BigDecimal.ZERO,
            chat = BigDecimal.ZERO
        )
    }
}

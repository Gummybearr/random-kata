package com.example.eventapp.consumer.mapper

import com.example.core.advertisement.AdvertisementId
import com.example.core.logger
import com.example.usecase.port.`in`.LiveAdvertisementUsecase

data class LiveAdvertisementEvent(
    val advertisementId: AdvertisementId
) {

    private val logger = logger()

    fun toLiveUsecaseCommand(): LiveAdvertisementUsecase.Command {
        logger.info("이벤트앱 매퍼에서 메시지큐 이벤트를 라이브 광고 요청 유즈케이스의 인풋으로 변경")
        return LiveAdvertisementUsecase.Command(
            advertisementId = advertisementId
        )
    }
}

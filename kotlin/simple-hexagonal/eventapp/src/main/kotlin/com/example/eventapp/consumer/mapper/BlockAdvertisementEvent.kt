package com.example.eventapp.consumer.mapper

import com.example.core.advertisement.AdvertisementId
import com.example.core.logger
import com.example.usecase.port.`in`.BlockAdvertisementUsecase

data class BlockAdvertisementEvent(
    val advertisementId: AdvertisementId
){

    private val logger = logger()

    fun toBlockUsecaseCommand(): BlockAdvertisementUsecase.Command {
        logger.info("이벤트앱 매퍼에서 웹 요청을 광고 차단 요청 유즈케이스의 인풋으로 변경")
        return BlockAdvertisementUsecase.Command(
            advertisementId = advertisementId
        )
    }
}
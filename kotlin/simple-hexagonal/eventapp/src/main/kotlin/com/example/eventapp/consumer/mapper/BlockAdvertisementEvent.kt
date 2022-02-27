package com.example.eventapp.consumer.mapper

import com.example.core.advertisement.AdvertisementId
import com.example.usecase.port.`in`.BlockAdvertisementUsecase

data class BlockAdvertisementEvent(
    val advertisementId: AdvertisementId
){
    fun toBlockUsecaseCommand(): BlockAdvertisementUsecase.Command {
        return BlockAdvertisementUsecase.Command(
            advertisementId = advertisementId
        )
    }
}
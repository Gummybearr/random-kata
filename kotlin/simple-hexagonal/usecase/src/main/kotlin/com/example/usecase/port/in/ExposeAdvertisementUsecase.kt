package com.example.usecase.port.`in`

import com.example.core.advertisement.AdvertisementId

interface ExposeAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId
    )
}
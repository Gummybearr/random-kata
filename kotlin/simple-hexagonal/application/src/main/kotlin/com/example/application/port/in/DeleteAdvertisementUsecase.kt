package com.example.application.port.`in`

import com.example.domain.advertisement.AdvertisementId

interface DeleteAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId
    )
}

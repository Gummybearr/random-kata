package com.example.usecase.port.`in`

import com.example.core.AdvertisementId

interface ModifyAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId
    )
}

package com.example.usecase.port.out

import com.example.core.advertisement.AdvertisementId

interface LiveAdvertisementPort {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId,
        val type: Type
    )

    enum class Type {
        ADD, REMOVE
    }
}

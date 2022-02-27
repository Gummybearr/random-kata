package com.example.usecase.port.`in`

import com.example.core.advertisement.Advertisement

interface DeleteAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisement: Advertisement
    )
}

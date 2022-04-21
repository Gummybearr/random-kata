package com.example.application.port.`in`

import com.example.domain.advertisement.Advertisement

interface CreateAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisement: Advertisement
    )
}

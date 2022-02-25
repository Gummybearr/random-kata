package com.example.usecase.port.`in`

import com.example.core.Advertisement

interface CreateNewAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisement: Advertisement
    )
}

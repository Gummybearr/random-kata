package com.example.usecase.port.`in`

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.Description
import com.example.core.advertisement.Image
import com.example.core.advertisement.Title

interface ModifyAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId,
        val title: Title?,
        val image: Image?,
        val description: Description?
    )
}

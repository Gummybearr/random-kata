package com.example.application.port.`in`

import com.example.domain.advertisement.AdvertisementId
import com.example.domain.advertisement.Description
import com.example.domain.advertisement.Image
import com.example.domain.advertisement.Title

interface ModifyAdvertisementUsecase {
    fun command(command: Command)

    data class Command(
        val advertisementId: AdvertisementId,
        val title: Title?,
        val image: Image?,
        val description: Description?
    )
}

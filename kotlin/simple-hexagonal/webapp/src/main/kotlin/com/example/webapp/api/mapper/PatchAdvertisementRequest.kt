package com.example.webapp.api.mapper

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.Description
import com.example.core.advertisement.Image
import com.example.core.advertisement.Title
import com.example.usecase.port.`in`.ModifyAdvertisementUsecase

data class PatchAdvertisementRequest(
    val advertisementId: Long,
    val title: String?,
    val image: String?,
    val description: String?
) {
    fun toModifyUsecaseCommand(): ModifyAdvertisementUsecase.Command {
        val advertisementId = AdvertisementId(advertisementId)
        val title = title?.let {
            Title(it)
        }
        val image = image?.let {
            Image(it)
        }
        val description = description?.let {
            Description(it)
        }

        return ModifyAdvertisementUsecase.Command(
            advertisementId = advertisementId,
            title = title,
            image = image,
            description = description
        )
    }
}

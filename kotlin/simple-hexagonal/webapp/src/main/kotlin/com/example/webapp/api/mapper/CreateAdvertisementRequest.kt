package com.example.webapp.api.mapper

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.Description
import com.example.core.advertisement.Image
import com.example.core.advertisement.Title
import com.example.usecase.port.`in`.CreateAdvertisementUsecase

data class CreateAdvertisementRequest(
    val title: String,
    val image: String,
    val description: String
) {
    fun toCreateUsecaseCommand(): CreateAdvertisementUsecase.Command {
        return CreateAdvertisementUsecase.Command(toAdvertisement())
    }

    private fun toAdvertisement(): Advertisement {
        val title = Title(title = title)
        val image = Image(url = image)
        val description = Description(description = description)
        return Advertisement.new(title = title, image = image, description = description)
    }
}

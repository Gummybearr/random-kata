package com.example.webapp.api.mapper

import com.example.domain.AdvertiserId
import com.example.domain.advertisement.Advertisement
import com.example.domain.advertisement.Description
import com.example.domain.advertisement.Image
import com.example.domain.advertisement.Title
import com.example.domain.logger
import com.example.application.port.`in`.CreateAdvertisementUsecase

data class CreateAdvertisementRequest(
    val title: String,
    val image: String,
    val description: String,
    val advertiserId: Long,
) {

    private val logger = logger()

    fun toCreateUsecaseCommand(): CreateAdvertisementUsecase.Command {
        logger.info("웹앱 매퍼에서 웹 요청을 광고 생성 요청 유즈케이스의 인풋으로 변경")
        return CreateAdvertisementUsecase.Command(toAdvertisement())
    }

    private fun toAdvertisement(): Advertisement {
        val title = Title(title = title)
        val image = Image(url = image)
        val description = Description(description = description)
        return Advertisement(advertiserId = AdvertiserId(advertiserId), title = title, image = image, description = description)
    }
}

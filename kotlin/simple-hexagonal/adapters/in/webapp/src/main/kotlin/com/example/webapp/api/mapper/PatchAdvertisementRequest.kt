package com.example.webapp.api.mapper

import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.Description
import com.example.core.advertisement.Image
import com.example.core.advertisement.Title
import com.example.core.logger
import com.example.application.port.`in`.ModifyAdvertisementUsecase

data class PatchAdvertisementRequest(
    val advertisementId: Long,
    val title: String?,
    val image: String?,
    val description: String?
) {

    private val logger = logger()

    fun toModifyUsecaseCommand(): ModifyAdvertisementUsecase.Command {
        logger.info("웹앱 매퍼에서 웹 요청을 광고 수정 요청 유즈케이스의 인풋으로 변경")
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

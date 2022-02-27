package com.example.webapp.api

import com.example.core.logger
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.webapp.api.mapper.CreateAdvertisementRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/advertisements")
class AdvertisementController(val createAdvertisementUsecase: CreateAdvertisementUsecase) {

    private val logger = logger()

    @PostMapping
    fun createAdvertisement(@RequestBody request: CreateAdvertisementRequest) {
        val command = CreateAdvertisementUsecase.Command(request.toAdvertisement())
        logger.info("웹 요청을 전달받아 광고 생성 유즈케이스를 호출")
        createAdvertisementUsecase.command(command)
    }
}

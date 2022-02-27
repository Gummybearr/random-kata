package com.example.webapp.api

import com.example.core.advertisement.AdvertisementId
import com.example.core.logger
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.`in`.QueryAdvertisementUsecase
import com.example.webapp.api.mapper.CreateAdvertisementRequest
import com.example.webapp.api.mapper.QueryAdvertisementResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/advertisements")
class AdvertisementController(
    val createAdvertisementUsecase: CreateAdvertisementUsecase,
    val queryAdvertisementUsecase: QueryAdvertisementUsecase
) {

    private val logger = logger()

    @PostMapping
    fun createAdvertisement(@RequestBody request: CreateAdvertisementRequest) {
        val command = CreateAdvertisementUsecase.Command(request.toAdvertisement())
        logger.info("웹 요청을 전달받아 광고 생성 유즈케이스를 호출")
        createAdvertisementUsecase.command(command)
    }

    @GetMapping("/{advertisementId}")
    fun queryAdvertisement(@PathVariable advertisementId: Long): QueryAdvertisementResponse? {
        val advertisementId = AdvertisementId(advertisementId)
        val query = QueryAdvertisementUsecase.Query(advertisementId = advertisementId)
        logger.info("웹 요청을 전달받아 광고 조회 유즈케이스를 호출")
        val advertisement = queryAdvertisementUsecase.query(query) ?: return null
        return QueryAdvertisementResponse.from(advertisement)
    }
}

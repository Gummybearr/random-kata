package com.example.webapp.api

import com.example.domain.advertisement.AdvertisementId
import com.example.domain.logger
import com.example.application.port.`in`.CreateAdvertisementUsecase
import com.example.application.port.`in`.DeleteAdvertisementUsecase
import com.example.application.port.`in`.ModifyAdvertisementUsecase
import com.example.application.port.`in`.QueryAdvertisementUsecase
import com.example.webapp.api.mapper.CreateAdvertisementRequest
import com.example.webapp.api.mapper.PatchAdvertisementRequest
import com.example.webapp.api.mapper.QueryAdvertisementResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/advertisements")
class AdvertisementController(
    val createAdvertisementUsecase: CreateAdvertisementUsecase,
    val queryAdvertisementUsecase: QueryAdvertisementUsecase,
    val modifyAdvertisementUsecase: ModifyAdvertisementUsecase,
    val deleteAdvertisementUsecase: DeleteAdvertisementUsecase
) {

    private val logger = logger()

    @PostMapping
    fun createAdvertisement(@RequestBody request: CreateAdvertisementRequest) {
        val command = request.toCreateUsecaseCommand()
        logger.info("웹 요청을 전달받아 광고 생성 유즈케이스를 호출")
        createAdvertisementUsecase.command(command)
    }

    @GetMapping("/{advertisementId}")
    fun queryAdvertisement(@PathVariable advertisementId: Long): QueryAdvertisementResponse? {
        val advertisementId = AdvertisementId(advertisementId)
        val query = QueryAdvertisementUsecase.Query(advertisementId = advertisementId)
        logger.info("웹 요청을 전달받아 광고 조회 유즈케이스를 호출")
        val result = queryAdvertisementUsecase.query(query) ?: return null
        return QueryAdvertisementResponse.from(result.advertisement)
    }

    @PatchMapping
    fun modifyAdvertisement(@RequestBody request: PatchAdvertisementRequest) {
        val command = request.toModifyUsecaseCommand()
        logger.info("웹 요청을 전달받아 광고 수정 유즈케이스를 호출")
        modifyAdvertisementUsecase.command(command)
    }

    @DeleteMapping("/{advertisementId}")
    fun deleteAdvertisement(@PathVariable advertisementId: Long) {
        val advertisementId = AdvertisementId(advertisementId)
        val command = DeleteAdvertisementUsecase.Command(advertisementId)
        logger.info("웹 요청을 전달받아 광고 삭제 유즈케이스를 호출")
        deleteAdvertisementUsecase.command(command)
    }
}

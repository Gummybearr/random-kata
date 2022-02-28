package com.example.usecase.adapter.`in`

import com.example.core.logger
import com.example.usecase.port.`in`.QueryAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPerformancePort
import com.example.usecase.port.out.AdvertisementPersistencePort

open class QueryAdvertisement(
    private val advertisementPersistencePort: AdvertisementPersistencePort,
    private val advertisementPerformancePort: AdvertisementPerformancePort
) : QueryAdvertisementUsecase {

    private val logger = logger()

    override fun query(query: QueryAdvertisementUsecase.Query): QueryAdvertisementUsecase.Result? {
        val advertisementId = query.advertisementId
        logger.info("광고를 데이터베이스에서 조회하기 위해 영속성 포트를 호출")
        val advertisement = advertisementPersistencePort.find(advertisementId) ?: return null

        logger.info("광고의 성과를 조회하기 위해 성과 포트를 호출")
        val advertisementPerformance = advertisementPerformancePort.find(advertisementId)

        return QueryAdvertisementUsecase.Result(
            advertisement = advertisement,
            performance = advertisementPerformance
        )
    }
}

package com.example.usecase.adapter.`in`

import com.example.core.advertisement.Advertisement
import com.example.core.logger
import com.example.usecase.port.`in`.QueryAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPersistencePort

open class QueryAdvertisement(
    private val advertisementPersistencePort: AdvertisementPersistencePort
) : QueryAdvertisementUsecase {

    private val logger = logger()

    override fun query(query: QueryAdvertisementUsecase.Query): Advertisement? {
        logger.info("광고를 데이터베이스에 조회하기 위해 영속성 포트를 호출")
        return advertisementPersistencePort.find(query.advertisementId)
    }
}

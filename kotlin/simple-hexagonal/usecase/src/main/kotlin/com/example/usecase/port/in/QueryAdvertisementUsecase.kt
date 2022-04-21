package com.example.usecase.port.`in`

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementId
import com.example.core.advertisement.AdvertisementPerformance

interface QueryAdvertisementUsecase {
    fun query(query: Query): Result?

    data class Query(
        val advertisementId: AdvertisementId
    )

    data class Result(
        val advertisement: Advertisement,
        val performance: AdvertisementPerformance?
    )
}

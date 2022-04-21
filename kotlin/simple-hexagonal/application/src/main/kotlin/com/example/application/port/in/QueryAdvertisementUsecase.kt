package com.example.application.port.`in`

import com.example.domain.advertisement.Advertisement
import com.example.domain.advertisement.AdvertisementId

interface QueryAdvertisementUsecase {
    fun query(query: Query): Result?

    data class Query(
        val advertisementId: AdvertisementId
    )

    data class Result(
        val advertisement: Advertisement
    )
}

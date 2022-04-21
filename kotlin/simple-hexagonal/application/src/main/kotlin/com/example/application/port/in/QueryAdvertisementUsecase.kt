package com.example.application.port.`in`

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementId

interface QueryAdvertisementUsecase {
    fun query(query: Query): Result?

    data class Query(
        val advertisementId: AdvertisementId
    )

    data class Result(
        val advertisement: Advertisement
    )
}

package com.example.usecase.port.`in`

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.AdvertisementId

interface QueryAdvertisementUsecase {
    fun query(query: Query): Advertisement?

    data class Query(
        val advertisementId: AdvertisementId
    )
}

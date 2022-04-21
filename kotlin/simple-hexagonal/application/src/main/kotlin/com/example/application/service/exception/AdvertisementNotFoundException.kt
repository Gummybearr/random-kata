package com.example.application.service.exception

import com.example.domain.advertisement.AdvertisementId

class AdvertisementNotFoundException(override val message: String) : RuntimeException() {
    constructor(advertiserId: AdvertisementId) : this("광고(${advertiserId.id})를 찾지 못했어요")
}
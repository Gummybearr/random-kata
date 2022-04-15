package com.example.adapter.exception

import com.example.core.advertisement.AdvertisementId

class AdvertisementNotFoundException(override val message: String) : RuntimeException() {
    constructor(advertiserId: AdvertisementId) : this("광고(${advertiserId.id})를 찾지 못했어요")
}
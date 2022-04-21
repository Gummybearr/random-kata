package com.example.domain.advertisement

import com.example.domain.DistributedId

data class AdvertisementId(val id: Long) {
    constructor() : this(DistributedId.nextId())
}

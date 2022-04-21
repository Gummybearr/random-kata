package com.example.core.advertisement

import com.example.core.DistributedId

data class AdvertisementId(val id: Long) {
    constructor() : this(DistributedId.nextId())
}

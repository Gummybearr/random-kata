package com.example.core.advertisement

import com.example.core.DistributedId

data class AdvertisementId(val id: Long) {
    companion object {
        fun new(): AdvertisementId {
            val id = DistributedId.nextId()
            return AdvertisementId(id)
        }
    }
}

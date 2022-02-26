package com.example.core

data class AdvertisementId(val id: Long) {
    companion object {
        operator fun invoke(): AdvertisementId {
            val id = DistributedId.nextId()
            return AdvertisementId(id)
        }
    }
}

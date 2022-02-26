package com.example.core

data class AdvertisementId(val id: Long) {
    companion object {
        fun new(): AdvertisementId {
            val id = DistributedId.nextId()
            return AdvertisementId(id)
        }
    }
}

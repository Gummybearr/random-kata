package com.example.usecase.port.out

import com.example.core.advertisement.Advertisement

interface AdvertisementInspectionPort {
    fun requestInspection(advertisement: Advertisement)
}

package com.example.usecase.port.out

import com.example.core.Advertisement

interface AdvertisementInspectionPort {
    fun requestInspection(advertisement: Advertisement)
}

package com.example.adapter.out

import com.example.core.advertisement.Advertisement
import com.example.usecase.port.out.AdvertisementInspectionPort

class MockAdvertisementInspectionPortAdapter : AdvertisementInspectionPort {

    private var didRequest = false

    override fun requestInspection(advertisement: Advertisement) {
        didRequest = true
    }

    fun didRequest() = didRequest

    fun clear(){
        didRequest = false
    }
}

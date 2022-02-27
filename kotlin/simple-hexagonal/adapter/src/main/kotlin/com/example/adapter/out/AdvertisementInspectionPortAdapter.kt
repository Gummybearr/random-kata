package com.example.adapter.out

import com.example.core.advertisement.Advertisement
import com.example.core.logger
import com.example.usecase.port.out.AdvertisementInspectionPort

class AdvertisementInspectionPortAdapter : AdvertisementInspectionPort {

    private val logger = logger()

    override fun requestInspection(advertisement: Advertisement) {
        logger.info("메시지큐로 광고 심사요청 이벤트를 전송")
    }
}

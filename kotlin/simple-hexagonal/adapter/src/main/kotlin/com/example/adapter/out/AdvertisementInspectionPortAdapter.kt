package com.example.adapter.out

import com.example.core.Advertisement
import com.example.usecase.port.out.AdvertisementInspectionPort
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AdvertisementInspectionPortAdapter : AdvertisementInspectionPort {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun requestInspection(advertisement: Advertisement) {
        logger.info("메시지큐로 광고 심사요청 이벤트를 전송")
    }
}

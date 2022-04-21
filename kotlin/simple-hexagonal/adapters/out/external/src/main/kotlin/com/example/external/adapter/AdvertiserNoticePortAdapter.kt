package com.example.external.adapter

import com.example.domain.logger
import com.example.application.port.out.AdvertiserNoticePort

class AdvertiserNoticePortAdapter : AdvertiserNoticePort {

    private val logger = logger()

    override fun noticeAdvertiser() {
        logger.info("메시지큐로 광고 알림 이벤트 전송")
    }
}
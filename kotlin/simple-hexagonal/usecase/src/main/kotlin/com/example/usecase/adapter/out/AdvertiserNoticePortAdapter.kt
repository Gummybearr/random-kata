package com.example.usecase.adapter.out

import com.example.core.logger
import com.example.usecase.port.out.AdvertiserNoticePort

class AdvertiserNoticePortAdapter : AdvertiserNoticePort {

    private val logger = logger()

    override fun noticeAdvertiser() {
        logger.info("메시지큐로 광고 알림 이벤트 전송")
    }
}

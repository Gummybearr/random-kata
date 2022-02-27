package com.example.adapter.out

import com.example.core.logger
import com.example.usecase.port.out.AdvertiserNoticePort

class AdvertiserNoticePortAdapter : AdvertiserNoticePort {

    private val logger = logger()

    override fun noticeAdvertiser() {
        logger.info("광고의 상태를 공지하기 위해 광고주 알림 이벤트를 전송")
    }
}

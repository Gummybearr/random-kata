package com.example.adapter.out

import com.example.application.port.out.AdvertiserNoticePort

class MockAdvertiserNoticePortAdapter : AdvertiserNoticePort {

    private var didNotice = false

    override fun noticeAdvertiser() {
        didNotice = true
    }

    fun didNotice() = didNotice

    fun clear() {
        didNotice = false
    }
}

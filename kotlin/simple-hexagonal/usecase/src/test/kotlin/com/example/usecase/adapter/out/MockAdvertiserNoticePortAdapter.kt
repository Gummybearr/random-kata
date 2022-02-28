package com.example.usecase.adapter.out

import com.example.usecase.port.out.AdvertiserNoticePort

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

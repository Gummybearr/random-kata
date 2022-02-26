package com.example.adapter.adapter.out

import com.example.core.Advertisement
import com.example.usecase.port.out.AdvertisementInspectionPort

class AdvertisementInspectionPortAdapter : AdvertisementInspectionPort {
    override fun requestInspection(advertisement: Advertisement) {
        // 심사 서버에 광고 메시지 이벤트를 발송!
    }
}

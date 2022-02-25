package com.example.adapter.adapter.out

import com.example.core.Advertisement
import com.example.core.Violation
import com.example.usecase.port.out.AdvertisementInspectionPort
import java.util.*

class AdvertisementInspectionPortAdapter : AdvertisementInspectionPort {
    override fun isAppropriate(advertisement: Advertisement): AdvertisementInspectionPort.InspectionNote {
        // 네트워크 요청을 보내서 값을 받아왔다고 가정! 
        val isAppropriate = true
        val violations = ArrayList<Violation>()

        return AdvertisementInspectionPort.InspectionNote(
            isAppropriate = isAppropriate,
            violations = violations
        )
    }
}

package com.example.usecase.port.out

import com.example.core.Advertisement
import com.example.core.Violation

interface AdvertisementInspectionPort {
    fun isAppropriate(advertisement: Advertisement): InspectionNote

    data class InspectionNote(
        val isAppropriate: Boolean,
        val violations: List<Violation>
    )
}

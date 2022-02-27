package com.example.core.advertisement

import com.example.core.logger

enum class AdvertisementStatus(val description: String) {
    PENDING("심사 대기중"),
    LIVE("광고중"),
    BLOCKED("차단됨"),
    DELETED("삭제됨");

    private val logger = logger()

    fun toLive(): AdvertisementStatus {
        val statusAfterLiveRequest = when (this) {
            PENDING -> LIVE
            else -> this
        }
        logger.info("광고 송출 요청으로 인해 광고 상태를 $this -> $statusAfterLiveRequest 로 변경")
        return statusAfterLiveRequest
    }
}

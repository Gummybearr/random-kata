package com.example.core.advertisement

import com.example.core.exception.IllegalAdvertisementStatusException
import com.example.core.logger

enum class AdvertisementStatus(val description: String) {
    PENDING("심사 대기중"),
    LIVE("광고중"),
    BLOCKED("차단됨"),
    DELETED("삭제됨");

    private val logger = logger()

    fun updateOnLiveRequest(): AdvertisementStatus {
        val statusAfterRequest = when (this) {
            PENDING -> LIVE
            else -> this
        }
        logger.info("광고 송출 요청으로 인해 광고 상태를 $this -> $statusAfterRequest 로 변경")
        return statusAfterRequest
    }

    fun updateOnModifyRequest(): AdvertisementStatus {
        logger.info("광고 수정 요청으로 인해 도메인 광고 상태 변경 요청")
        return when (this) {
            PENDING -> PENDING
            LIVE -> PENDING
            else -> throw IllegalAdvertisementStatusException("$this 상태에서는 수정할 수 없어요")
        }
    }
}

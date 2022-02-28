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
        logger.info("광고 송출 요청으로 인해 도메인 광고 상태 변경")
        return when (this) {
            PENDING -> LIVE
            LIVE -> LIVE
            else -> throw IllegalAdvertisementStatusException("$this 상태에서는 송출할 수 없어요")
        }
    }

    fun updateOnModifyRequest(): AdvertisementStatus {
        logger.info("광고 수정 요청으로 인해 도메인 광고 상태 변경")
        return when (this) {
            PENDING -> PENDING
            LIVE -> PENDING
            else -> throw IllegalAdvertisementStatusException("$this 상태에서는 수정할 수 없어요")
        }
    }

    fun updateOnBlockRequest(): AdvertisementStatus {
        logger.info("광고 차단 요청으로 인해 도메인 광고 상태 변경")
        return when (this) {
            PENDING -> BLOCKED
            LIVE -> BLOCKED
            BLOCKED -> BLOCKED
            DELETED -> throw IllegalAdvertisementStatusException("$this 상태에서는 차단할 수 없어요")
        }
    }
}

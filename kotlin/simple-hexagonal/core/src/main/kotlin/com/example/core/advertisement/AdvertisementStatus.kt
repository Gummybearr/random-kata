package com.example.core.advertisement

enum class AdvertisementStatus(val description: String) {
    PENDING("심사 대기중"),
    LIVE("광고중"),
    BLOCKED("차단됨"),
    DELETED("삭제됨")
}
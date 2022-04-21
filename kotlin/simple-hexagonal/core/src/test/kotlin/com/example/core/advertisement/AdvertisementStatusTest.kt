package com.example.core.advertisement

import com.example.core.exception.IllegalAdvertisementStatusException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AdvertisementStatusTest {

    @Test
    fun `PENDING상태인 광고는 송출요청시 LIVE상태가 된다`() {
        val status = AdvertisementStatus.PENDING
        assert(status.updateOnLiveRequest() == AdvertisementStatus.LIVE)
    }

    @Test
    fun `BLOCKED상태인 광고는 송출요청시 IllegalAdvertisementStatusException이 터진다`() {
        val status = AdvertisementStatus.BLOCKED
        assertThrows<IllegalAdvertisementStatusException> { status.updateOnLiveRequest() }
    }

    @Test
    fun `LIVE 상태인 광고를 수정하면 PENDING 상태가 된다`() {
        val status = AdvertisementStatus.LIVE
        assert(status.updateOnModifyRequest() == AdvertisementStatus.PENDING)
    }

    @Test
    fun `DELETED 상태인 광고를 수정하면 IllegalAdvertisementStatusException이 터진다`() {
        val status = AdvertisementStatus.DELETED
        assertThrows<IllegalAdvertisementStatusException> { status.updateOnModifyRequest() }
    }

    @Test
    fun `LIVE 상태인 광고를 차단하면 BLOCKED 상태가 된다`() {
        val status = AdvertisementStatus.LIVE
        assert(status.updateOnBlockRequest() == AdvertisementStatus.BLOCKED)
    }

    @Test
    fun `DELETED 상태인 광고를 차단하면 IllegalAdvertisementStatusException이 터진다`() {
        val status = AdvertisementStatus.DELETED
        assertThrows<IllegalAdvertisementStatusException> { status.updateOnBlockRequest() }
    }
}

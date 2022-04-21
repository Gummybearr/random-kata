package com.example.usecase.adapter.`in`

import com.example.core.advertisement.Advertisement
import com.example.core.advertisement.Description
import com.example.core.advertisement.Image
import com.example.core.advertisement.Title
import com.example.adapter.out.MockAdvertisementInspectionPortAdapter
import com.example.adapter.out.MockAdvertisementPersistencePortAdapter
import com.example.adapter.out.MockAdvertiserNoticePortAdapter
import com.example.core.AdvertiserId
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class CreateAdvertisementTest {

    private val advertisementInspectionPort = MockAdvertisementInspectionPortAdapter()
    private val advertisementPersistencePort = MockAdvertisementPersistencePortAdapter()
    private val advertiserNoticePort = MockAdvertiserNoticePortAdapter()

    private val createAdvertisement =
        CreateAdvertisement(advertisementInspectionPort, advertisementPersistencePort, advertiserNoticePort)

    @AfterEach
    fun reset() {
        advertisementInspectionPort.clear()
        advertisementPersistencePort.clear()
        advertiserNoticePort.clear()
    }

    @Test
    fun `광고를 만들 수 있다`() {
        `광고 생성`()
    }

    @Test
    fun `광고를 생성하면 알림이 간다`() {
        `광고 생성`()
        assert(advertiserNoticePort.didNotice())
    }

    private fun `광고 생성`() {
        val advertisement = Advertisement(
            title = Title("asasdfasdf"),
            image = Image("address in s3 bucket"),
            description = Description("asdfasdfasdlkfjhasldkfjh"),
            advertiserId = AdvertiserId(1L),
        )
        val command = CreateAdvertisementUsecase.Command(advertisement = advertisement)
        createAdvertisement.command(command)
    }
}

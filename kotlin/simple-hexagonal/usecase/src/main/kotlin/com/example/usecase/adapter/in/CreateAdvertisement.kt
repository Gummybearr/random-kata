package com.example.usecase.adapter.`in`

import com.example.core.logger
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import javax.transaction.Transactional

open class CreateAdvertisement(
    private val advertisementInspectionPort: AdvertisementInspectionPort,
    private val advertisementPersistencePort: AdvertisementPersistencePort,
    private val advertiserNoticePort: AdvertiserNoticePort
) : CreateAdvertisementUsecase {

    private val logger = logger()

    @Transactional
    override fun command(command: CreateAdvertisementUsecase.Command) {
        val advertisement = command.advertisement

        logger.info("광고를 데이터베이스에 저장하기 위해 영속성 포트를 호출")
        advertisementPersistencePort.save(advertisement)

        logger.info("광고 심사를 위해 심사 포트 호출")
        advertisementInspectionPort.requestInspection(advertisement)

        logger.info("광고주에게 광고 상태를 알리기 위해 알림 포트 호출")
        advertiserNoticePort.noticeAdvertiser()
    }
}

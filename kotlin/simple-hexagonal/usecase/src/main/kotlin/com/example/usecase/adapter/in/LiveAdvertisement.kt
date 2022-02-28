package com.example.usecase.adapter.`in`

import com.example.core.logger
import com.example.usecase.port.`in`.LiveAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort

class LiveAdvertisement(
    private val advertisementPersistencePort: AdvertisementPersistencePort,
    private val advertiserNoticePort: AdvertiserNoticePort
) : LiveAdvertisementUsecase {

    private val logger = logger()

    override fun command(command: LiveAdvertisementUsecase.Command) {
        logger.info("광고를 데이터베이스에서 조회하기 위해 영속성 포트를 호출")
        val advertisement = advertisementPersistencePort.find(command.advertisementId) ?: return

        logger.info("광고를 송출 상태로 바꾸기 위해 광고 도메인 객체를 호출")
        val advertisementOnBlock = advertisement.live()

        logger.info("광고를 데이터베이스에 저장하기 위해 영속성 포트를 호출")
        advertisementPersistencePort.save(advertisementOnBlock)

        logger.info("광고주에게 광고 상태를 알리기 위해 알림 포트 호출")
        advertiserNoticePort.noticeAdvertiser()
    }
}
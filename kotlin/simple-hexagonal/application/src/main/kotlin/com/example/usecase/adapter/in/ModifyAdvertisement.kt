package com.example.usecase.adapter.`in`

import com.example.core.logger
import com.example.usecase.adapter.`in`.exception.AdvertisementNotFoundException
import com.example.usecase.port.`in`.ModifyAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import javax.transaction.Transactional

open class ModifyAdvertisement(
    private val advertisementPersistencePort: AdvertisementPersistencePort,
    private val advertiserNoticePort: AdvertiserNoticePort
) : ModifyAdvertisementUsecase {

    private val logger = logger()

    @Transactional
    override fun command(command: ModifyAdvertisementUsecase.Command) {
        val advertisementId = command.advertisementId

        logger.info("광고를 데이터베이스에서 조회하기 위해 영속성 포트를 호출")
        val advertisement =
            advertisementPersistencePort.find(advertisementId) ?: throw AdvertisementNotFoundException(advertisementId)

        logger.info("광고를 수정하기 위해 광고 도메인 객체를 호출")
        val modifiedAdvertisement = advertisement.update(
            newTitle = command.title,
            newImage = command.image,
            newDescription = command.description
        )

        logger.info("광고를 데이터베이스에 저장하기 위해 영속성 포트를 호출")
        advertisementPersistencePort.save(modifiedAdvertisement)

        logger.info("광고주에게 광고 상태를 알리기 위해 알림 포트 호출")
        advertiserNoticePort.noticeAdvertiser()
    }
}

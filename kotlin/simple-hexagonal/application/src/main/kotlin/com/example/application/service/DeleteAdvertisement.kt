package com.example.application.service

import com.example.domain.logger
import com.example.application.port.`in`.DeleteAdvertisementUsecase
import com.example.application.port.out.AdvertisementPersistencePort

open class DeleteAdvertisement(
    private val advertisementPersistencePort: AdvertisementPersistencePort
) : DeleteAdvertisementUsecase {

    private val logger = logger()

    override fun command(command: DeleteAdvertisementUsecase.Command) {
        logger.info("광고를 데이터베이스에서 제거하기 위해 영속성 포트를 호출")
        advertisementPersistencePort.delete(command.advertisementId)
    }
}

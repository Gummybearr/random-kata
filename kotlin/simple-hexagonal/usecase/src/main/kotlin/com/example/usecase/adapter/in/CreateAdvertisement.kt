package com.example.usecase.adapter.`in`

import com.example.core.logger
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPort
import javax.transaction.Transactional

open class CreateAdvertisement(
    private val advertisementInspectionPort: AdvertisementInspectionPort,
    private val advertisementPort: AdvertisementPort
) : CreateAdvertisementUsecase {

    private val logger = logger()

    @Transactional
    override fun command(command: CreateAdvertisementUsecase.Command) {
        val advertisement = command.advertisement
        logger.info("광고를 데이터베이스에 저장하기 위해 광고 포트를 호출")
        advertisementPort.save(advertisement)
        logger.info("광고 심사를 위해 심사 포트 호출")
        advertisementInspectionPort.requestInspection(advertisement)
    }
}

package com.example.usecase.adapter.`in`

import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPort
import javax.transaction.Transactional

open class CreateAdvertisement(
    private val advertisementInspectionPort: AdvertisementInspectionPort,
    private val advertisementPort: AdvertisementPort
) : CreateAdvertisementUsecase {

    @Transactional
    override fun command(command: CreateAdvertisementUsecase.Command) {
        val advertisement = command.advertisement
        advertisementPort.save(advertisement)
        advertisementInspectionPort.requestInspection(advertisement)
    }
}

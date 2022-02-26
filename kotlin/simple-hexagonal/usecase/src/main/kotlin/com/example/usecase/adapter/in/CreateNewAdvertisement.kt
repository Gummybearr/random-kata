package com.example.usecase.adapter.`in`

import com.example.usecase.port.`in`.CreateNewAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPort

open class CreateNewAdvertisement(
    private val advertisementInspectionPort: AdvertisementInspectionPort,
    private val advertisementPort: AdvertisementPort
) : CreateNewAdvertisementUsecase {

    override fun command(command: CreateNewAdvertisementUsecase.Command) {
        val advertisement = command.advertisement
        advertisementPort.save(advertisement)
        advertisementInspectionPort.requestInspection(advertisement)
    }
}

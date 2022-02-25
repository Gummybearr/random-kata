package com.example.usecase.adapter.`in`

import com.example.usecase.port.`in`.CreateNewAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPort
import com.example.usecase.port.out.MessagePort

open class CreateNewAdvertisement(
    private val advertisementInspectionPort: AdvertisementInspectionPort,
    private val advertisementPort: AdvertisementPort,
    private val messagePort: MessagePort
) : CreateNewAdvertisementUsecase {
    override fun command(command: CreateNewAdvertisementUsecase.Command) {

        val advertisement = command.advertisement
        val inspection = advertisementInspectionPort.isAppropriate(advertisement)
        advertisementPort.save(advertisement)

        if (inspection.isAppropriate) {
            messagePort.noticeAdvertiser()
        }
    }
}

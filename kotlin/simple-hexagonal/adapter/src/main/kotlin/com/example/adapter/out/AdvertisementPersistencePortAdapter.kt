package com.example.adapter.out

import com.example.core.advertisement.AdvertisementId
import com.example.core.logger
import com.example.data.repository.AdvertisementRepository
import com.example.adapter.out.mapper.AdvertisementMapper
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.core.advertisement.Advertisement as CoreAdvertisement

class AdvertisementPersistencePortAdapter(
    private val advertisementRepository: AdvertisementRepository
) : AdvertisementPersistencePort {

    private val logger = logger()

    override fun find(advertisementId: AdvertisementId): CoreAdvertisement? {
        logger.info("광고 영속성 어댑터에서 데이터베이스에 광고 조회 요청 전송")
        val advertisement = advertisementRepository.find(advertisementId) ?: return null
        return AdvertisementMapper.toApplication(advertisement)
    }

    override fun save(coreAdvertisement: CoreAdvertisement) {
        logger.info("광고 영속성 어댑터에서 데이터베이스에 광고 저장 요청 전송")
        val advertisement = AdvertisementMapper.toPersistence(coreAdvertisement)
        advertisementRepository.save(advertisement)
    }

    override fun delete(advertisementId: AdvertisementId) {
        logger.info("광고 영속성 어댑터에서 데이터베이스에 광고 삭제 요청 전송")
        advertisementRepository.delete(advertisementId)
    }
}

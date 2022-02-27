package com.example.adapter.out

import com.example.adapter.out.mapper.AdvertisementMapper
import com.example.core.advertisement.Advertisement as CoreAdvertisement
import com.example.core.advertisement.AdvertisementId
import com.example.data.repository.AdvertisementRepository
import com.example.usecase.port.out.AdvertisementPersistencePort

class AdvertisementPersistencePortAdapter(
    private val advertisementRepository: AdvertisementRepository,
    private val advertisementMapper: AdvertisementMapper
) : AdvertisementPersistencePort {
    override fun find(advertisementId: AdvertisementId): CoreAdvertisement? {
        val advertisement = advertisementRepository.find(advertisementId) ?: return null
        return advertisementMapper.toApplication(advertisement)
    }

    override fun save(coreAdvertisement: CoreAdvertisement) {
        val advertisement = advertisementMapper.toPersistence(coreAdvertisement)
        advertisementRepository.save(advertisement)
    }
}
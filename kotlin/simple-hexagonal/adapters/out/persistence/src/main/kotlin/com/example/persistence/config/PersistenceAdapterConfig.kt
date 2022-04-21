package com.example.persistence.config

import com.example.persistence.adapter.AdvertisementPersistencePortAdapter
import com.example.persistence.repository.AdvertisementRepository
import com.example.application.port.out.AdvertisementPersistencePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(PersistenceConfig::class)
class PersistenceAdapterConfig {

    @Bean
    fun advertisementPort(
        advertisementRepository: AdvertisementRepository,
    ): AdvertisementPersistencePort {
        return AdvertisementPersistencePortAdapter(advertisementRepository)
    }
}

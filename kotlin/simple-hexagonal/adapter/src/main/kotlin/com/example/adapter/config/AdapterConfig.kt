package com.example.adapter.config

import com.example.adapter.out.AdvertisementPersistencePortAdapter
import com.example.adapter.out.AdvertiserNoticePortAdapter
import com.example.data.config.PersistenceConfig
import com.example.data.repository.AdvertisementRepository
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(PersistenceConfig::class)
class AdapterConfig {

    @Bean
    fun advertisementPort(
        advertisementRepository: AdvertisementRepository,
    ): AdvertisementPersistencePort {
        return AdvertisementPersistencePortAdapter(advertisementRepository)
    }

    @Bean
    fun advertiserNoticePort(): AdvertiserNoticePort {
        return AdvertiserNoticePortAdapter()
    }
}

package com.example.webapp.config

import com.example.usecase.adapter.`in`.CreateAdvertisement
import com.example.usecase.adapter.`in`.QueryAdvertisement
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.`in`.QueryAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPersistencePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createAdvertisement(
        advertisementInspectionPort: AdvertisementInspectionPort,
        advertisementPersistencePort: AdvertisementPersistencePort
    ): CreateAdvertisementUsecase {
        return CreateAdvertisement(advertisementInspectionPort, advertisementPersistencePort)
    }

    @Bean
    fun queryAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort
    ): QueryAdvertisementUsecase {
        return QueryAdvertisement(advertisementPersistencePort)
    }
}

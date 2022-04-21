package com.example.webapp.config

import com.example.usecase.service.CreateAdvertisement
import com.example.usecase.service.DeleteAdvertisement
import com.example.usecase.service.ModifyAdvertisement
import com.example.usecase.service.QueryAdvertisement
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.`in`.DeleteAdvertisementUsecase
import com.example.usecase.port.`in`.ModifyAdvertisementUsecase
import com.example.usecase.port.`in`.QueryAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort,
        advertiserNoticePort: AdvertiserNoticePort
    ): CreateAdvertisementUsecase {
        return CreateAdvertisement(advertisementPersistencePort, advertiserNoticePort)
    }

    @Bean
    fun queryAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort
    ): QueryAdvertisementUsecase {
        return QueryAdvertisement(advertisementPersistencePort)
    }

    @Bean
    fun modifyAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort,
        advertiserNoticePort: AdvertiserNoticePort
    ): ModifyAdvertisementUsecase {
        return ModifyAdvertisement(advertisementPersistencePort, advertiserNoticePort)
    }

    @Bean
    fun deleteAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort,
    ): DeleteAdvertisementUsecase {
        return DeleteAdvertisement(advertisementPersistencePort)
    }
}

package com.example.webapp.config

import com.example.application.port.`in`.CreateAdvertisementUsecase
import com.example.application.port.`in`.DeleteAdvertisementUsecase
import com.example.application.port.`in`.ModifyAdvertisementUsecase
import com.example.application.port.`in`.QueryAdvertisementUsecase
import com.example.application.port.out.AdvertisementPersistencePort
import com.example.application.port.out.AdvertiserNoticePort
import com.example.application.service.CreateAdvertisement
import com.example.application.service.DeleteAdvertisement
import com.example.application.service.ModifyAdvertisement
import com.example.application.service.QueryAdvertisement
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

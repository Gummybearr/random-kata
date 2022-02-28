package com.example.eventapp.config

import com.example.usecase.adapter.`in`.BlockAdvertisement
import com.example.usecase.adapter.`in`.LiveAdvertisement
import com.example.usecase.port.`in`.BlockAdvertisementUsecase
import com.example.usecase.port.`in`.LiveAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsecaseConfig {

    @Bean
    fun blockAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort,
        advertiserNoticePort: AdvertiserNoticePort
    ): BlockAdvertisementUsecase {
        return BlockAdvertisement(advertisementPersistencePort, advertiserNoticePort)
    }

    @Bean
    fun liveAdvertisement(
        advertisementPersistencePort: AdvertisementPersistencePort,
        advertiserNoticePort: AdvertiserNoticePort
    ): LiveAdvertisementUsecase {
        return LiveAdvertisement(advertisementPersistencePort, advertiserNoticePort)
    }
}

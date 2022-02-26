package com.example.webapp.config

import com.example.usecase.adapter.`in`.CreateAdvertisement
import com.example.usecase.port.`in`.CreateAdvertisementUsecase
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createAdvertisement(
        advertisementInspectionPort: AdvertisementInspectionPort,
        advertisementPort: AdvertisementPort
    ): CreateAdvertisementUsecase {
        return CreateAdvertisement(advertisementInspectionPort, advertisementPort)
    }
}
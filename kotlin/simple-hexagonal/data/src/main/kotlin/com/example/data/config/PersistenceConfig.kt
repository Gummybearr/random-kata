package com.example.data.config

import com.example.data.repository.AdvertisementRepository
import com.example.data.repository.AdvertisementRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersistenceConfig {
    @Bean
    fun advertisementRepository(): AdvertisementRepository {
        return AdvertisementRepositoryImpl()
    }
}
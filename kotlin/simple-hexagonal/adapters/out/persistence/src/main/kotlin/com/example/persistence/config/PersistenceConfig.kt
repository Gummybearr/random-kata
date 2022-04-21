package com.example.persistence.config

import com.example.persistence.repository.AdvertisementRepository
import com.example.persistence.repository.AdvertisementRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersistenceConfig {
    @Bean
    fun advertisementRepository(): AdvertisementRepository {
        return AdvertisementRepositoryImpl()
    }
}
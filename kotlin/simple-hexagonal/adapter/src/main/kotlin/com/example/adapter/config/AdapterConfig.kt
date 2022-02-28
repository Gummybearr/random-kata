package com.example.adapter.config

import com.example.adapter.out.AdvertisementInspectionPortAdapter
import com.example.adapter.out.AdvertisementPerformancePortAdapter
import com.example.adapter.out.AdvertisementPersistencePortAdapter
import com.example.adapter.out.AdvertiserNoticePortAdapter
import com.example.adapter.out.mapper.AdvertisementMapper
import com.example.data.config.PersistenceConfig
import com.example.data.repository.AdvertisementRepository
import com.example.usecase.port.out.AdvertisementInspectionPort
import com.example.usecase.port.out.AdvertisementPerformancePort
import com.example.usecase.port.out.AdvertisementPersistencePort
import com.example.usecase.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(PersistenceConfig::class)
class AdapterConfig {
    @Bean
    fun advertisementInspectionPort(): AdvertisementInspectionPort {
        return AdvertisementInspectionPortAdapter()
    }

    @Bean
    fun advertisementPort(advertisementRepository: AdvertisementRepository, advertisementMapper: AdvertisementMapper): AdvertisementPersistencePort {
        return AdvertisementPersistencePortAdapter(advertisementRepository, advertisementMapper)
    }

    @Bean
    fun advertiserNoticePort(): AdvertiserNoticePort {
        return AdvertiserNoticePortAdapter()
    }

    @Bean
    fun advertisementPerformancePort(): AdvertisementPerformancePort {
        return AdvertisementPerformancePortAdapter()
    }
}

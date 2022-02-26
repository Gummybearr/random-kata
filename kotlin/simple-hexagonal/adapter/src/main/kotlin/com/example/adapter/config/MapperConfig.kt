package com.example.adapter.config

import com.example.adapter.out.mapper.AdvertisementMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MapperConfig {
    @Bean
    fun advertisementMapper(): AdvertisementMapper {
        return AdvertisementMapper()
    }
}
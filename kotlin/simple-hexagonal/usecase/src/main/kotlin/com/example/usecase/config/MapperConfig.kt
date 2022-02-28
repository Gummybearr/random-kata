package com.example.usecase.config

import com.example.usecase.adapter.out.mapper.AdvertisementMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MapperConfig {
    @Bean
    fun advertisementMapper(): AdvertisementMapper {
        return AdvertisementMapper()
    }
}

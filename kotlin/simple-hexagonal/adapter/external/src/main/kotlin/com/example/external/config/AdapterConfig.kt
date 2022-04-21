package com.example.external.config

import com.example.external.adapter.AdvertiserNoticePortAdapter
import com.example.usecase.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfig {
    @Bean
    fun advertiserNoticePort(): AdvertiserNoticePort {
        return AdvertiserNoticePortAdapter()
    }
}

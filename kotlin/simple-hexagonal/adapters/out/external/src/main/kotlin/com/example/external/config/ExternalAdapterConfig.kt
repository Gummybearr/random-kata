package com.example.external.config

import com.example.external.adapter.AdvertiserNoticePortAdapter
import com.example.application.port.out.AdvertiserNoticePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExternalAdapterConfig {
    @Bean
    fun advertiserNoticePort(): AdvertiserNoticePort {
        return AdvertiserNoticePortAdapter()
    }
}

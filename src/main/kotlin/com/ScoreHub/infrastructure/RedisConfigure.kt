package com.ScoreHub.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class RedisConfigure {
    @Bean
    open fun getRedisProperties(): RedisProperties = RedisProperties()
}
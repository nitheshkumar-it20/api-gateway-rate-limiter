package com.healthcare.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConfig {

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        // 5 requests per second, burst capacity 10
        return new RedisRateLimiter(5, 10);
    }
}

package com.vishal.mini_cache.config;

import com.vishal.mini_cache.cache.Cache;
import com.vishal.mini_cache.cache.InMemoryCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<String, Object> cache() {
        return new InMemoryCache<>();
    }
}
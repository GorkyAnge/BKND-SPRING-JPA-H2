package com.gorkyange.apirest.apirest.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class DBCacheConfig {

    public static final String USERS_CACHE = "users";
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(USERS_CACHE);
    }

}

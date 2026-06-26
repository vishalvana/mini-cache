package com.vishal.mini_cache.service;

import com.vishal.mini_cache.cache.Cache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheCleanupService {

    private final Cache<String, Object> cache;

    public CacheCleanupService(
            Cache<String, Object> cache) {

        this.cache = cache;
    }



    @Scheduled(fixedRate = 20000)
    public void cleanup() {

        cache.cleanupExpiredEntries();

        System.out.println(
                "Expired cache cleanup completed"
        );
    }
}
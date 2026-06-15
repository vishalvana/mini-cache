package com.vishal.mini_cache.service;

import com.vishal.mini_cache.cache.Cache;
import com.vishal.mini_cache.dto.StatsResponse;
import com.vishal.mini_cache.model.CacheStats;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final Cache<String, Object> cache;

    public CacheService(Cache<String, Object> cache) {
        this.cache = cache;
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void delete(String key) {
        cache.remove(key);
    }

    public int size() {
        return cache.size();
    }

    public StatsResponse getStats() {

        CacheStats stats =
                cache.getStats();

        return new StatsResponse(
                stats.getHits(),
                stats.getMisses(),
                stats.getEvictions(),
                stats.getHitRate(),
                cache.size()
        );
    }
}
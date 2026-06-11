package com.vishal.mini_cache.service;

import com.vishal.mini_cache.model.CacheEntry;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {

    private final ConcurrentHashMap<String, CacheEntry> cache =
            new ConcurrentHashMap<>();

    public void put(String key, String value) {
        cache.put(key, new CacheEntry(value));
    }

    public Object get(String key) {

        CacheEntry entry = cache.get(key);

        if(entry == null) {
            return null;
        }

        return entry.getValue();
    }

    public void delete(String key) {
        cache.remove(key);
    }
}
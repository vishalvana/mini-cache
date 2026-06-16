package com.vishal.mini_cache.cache;

import com.vishal.mini_cache.model.CacheStats;

public interface Cache<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    int size();

    CacheStats getStats();

    void cleanupExpiredEntries();
}
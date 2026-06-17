package com.vishal.mini_cache.cache;

import com.vishal.mini_cache.model.CacheEntry;
import com.vishal.mini_cache.model.CacheStats;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V>
        implements Cache<K, V> {

    private static final long DEFAULT_TTL =
            60_000;

    private final ConcurrentHashMap<K, CacheEntry<V>>
            storage = new ConcurrentHashMap<>();

    private final CacheStats stats =
            new CacheStats();

    @Override
    public void put(K key, V value) {

        long now = System.currentTimeMillis();

        CacheEntry<V> entry =
                new CacheEntry<>(
                        value,
                        now,
                        now + DEFAULT_TTL
                );

        storage.put(key, entry);
    }

    @Override
    public V get(K key) {

        CacheEntry<V> entry =
                storage.get(key);

        if (entry == null) {

            stats.recordMiss();

            return null;
        }

        long now =
                System.currentTimeMillis();

        if (now > entry.getExpiryTime()) {

            storage.remove(key);

            stats.recordMiss();

            return null;
        }

        entry.updateAccessMetadata();

        stats.recordHit();

        return entry.getValue();
    }

    @Override
    public void remove(K key) {
        storage.remove(key);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public CacheStats getStats() {
        return stats;
    }

    @Override
    public void cleanupExpiredEntries() {

        long now =
                System.currentTimeMillis();

        storage.entrySet().removeIf(
                entry ->
                        now >
                                entry.getValue()
                                        .getExpiryTime()
        );
    }
}
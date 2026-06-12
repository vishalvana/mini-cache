package com.vishal.mini_cache.cache;

import com.vishal.mini_cache.model.CacheEntry;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V>
        implements Cache<K, V> {

    private static final long DEFAULT_TTL =
            10000; // 10 seconds for testing

    private final ConcurrentHashMap<K, CacheEntry<V>>
            storage = new ConcurrentHashMap<>();

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
            return null;
        }

        long now = System.currentTimeMillis();

        if (now > entry.getExpiryTime()) {

            storage.remove(key);

            return null;
        }

        entry.updateAccessMetadata();

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
}
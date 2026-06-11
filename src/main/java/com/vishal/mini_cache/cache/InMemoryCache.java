package com.vishal.mini_cache.cache;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V>
        implements Cache<K, V> {

    private final ConcurrentHashMap<K, V> storage =
            new ConcurrentHashMap<>();

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return storage.get(key);
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
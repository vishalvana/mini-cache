package com.vishal.mini_cache.cache;

public interface Cache<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    int size();
}
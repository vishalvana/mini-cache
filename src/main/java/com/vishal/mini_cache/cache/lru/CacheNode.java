package com.vishal.mini_cache.cache.lru;

import com.vishal.mini_cache.model.CacheEntry;

public class CacheNode<K, V> {

    private K key;

    private CacheEntry<V> entry;

    CacheNode<K, V> prev;

    CacheNode<K, V> next;

    public CacheNode(K key, CacheEntry<V> entry) {
        this.key = key;
        this.entry = entry;
    }

    public K getKey() {
        return key;
    }

    public CacheEntry<V> getEntry() {
        return entry;
    }

    public void setEntry(CacheEntry<V> entry) {
        this.entry = entry;
    }
}
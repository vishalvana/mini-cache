package com.vishal.mini_cache.cache.lru;

import com.vishal.mini_cache.model.CacheEntry;
import lombok.Getter;
import lombok.Setter;

public class CacheNode<K, V> {

    @Getter
    private K key;

    @Setter
    @Getter
    private CacheEntry<V> entry;

    CacheNode<K, V> prev;

    CacheNode<K, V> next;

    public CacheNode(K key, CacheEntry<V> entry) {
        this.key = key;
        this.entry = entry;
    }

}
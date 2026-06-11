package com.vishal.mini_cache.model;

public class CacheEntry {

    private Object value;

    public CacheEntry(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
package com.vishal.mini_cache.model;

public class CacheEntry<V> {

    private final V value;

    private final long creationTime;

    private long lastAccessTime;

    private final long expiryTime;

    private long accessCount;

    public CacheEntry(
            V value,
            long creationTime,
            long expiryTime) {

        this.value = value;
        this.creationTime = creationTime;
        this.expiryTime = expiryTime;
        this.lastAccessTime = creationTime;
        this.accessCount = 0;
    }

    public V getValue() {
        return value;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public long getAccessCount() {
        return accessCount;
    }

    public void updateAccessMetadata() {
        this.lastAccessTime = System.currentTimeMillis();
        this.accessCount++;
    }
}
package com.vishal.mini_cache.dto;

public class StatsResponse {

    private long hits;
    private long misses;
    private long evictions;
    private double hitRate;
    private int currentSize;

    public StatsResponse(
            long hits,
            long misses,
            long evictions,
            double hitRate,
            int currentSize) {

        this.hits = hits;
        this.misses = misses;
        this.evictions = evictions;
        this.hitRate = hitRate;
        this.currentSize = currentSize;
    }

    public long getHits() {
        return hits;
    }

    public long getMisses() {
        return misses;
    }

    public long getEvictions() {
        return evictions;
    }

    public double getHitRate() {
        return hitRate;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
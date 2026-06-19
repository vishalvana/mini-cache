package com.vishal.mini_cache.controller;

import com.vishal.mini_cache.dto.CacheRequest;
import com.vishal.mini_cache.dto.StatsResponse;
import com.vishal.mini_cache.service.CacheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Cache API",
        description = "Custom In-Memory Cache Operations"
)
@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Operation(
            summary = "Store a value in cache"
    )
    @PostMapping
    public String put(
            @RequestBody CacheRequest request) {

        cacheService.put(
                request.getKey(),
                request.getValue(),
                request.getTtlSeconds()
        );

        return "Stored Successfully";
    }


    @Operation(
            summary = "Retrieve value by key"
    )
    @GetMapping("/{key}")
    public Object get(
            @PathVariable String key) {

        return cacheService.get(key);
    }


    @Operation(
            summary = "Delete cache entry"
    )
    @DeleteMapping("/{key}")
    public String delete(
            @PathVariable String key) {

        cacheService.delete(key);

        return "Deleted Successfully";
    }

    @Operation(
            summary = "Get cache size"
    )
    @GetMapping("/size")
    public int size() {
        return cacheService.size();
    }

    @Operation(
            summary = "Get cache Summary Statistics"
    )
    @GetMapping("/stats")
    public StatsResponse stats() {
        return cacheService.getStats();
    }
}
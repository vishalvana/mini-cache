package com.vishal.mini_cache.controller;

import com.vishal.mini_cache.dto.CacheRequest;
import com.vishal.mini_cache.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping
    public String put(@RequestBody CacheRequest request) {

        cacheService.put(
                request.getKey(),
                request.getValue()
        );

        return "Stored Successfully";
    }

    @GetMapping("/{key}")
    public Object get(@PathVariable String key) {

        return cacheService.get(key);
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable String key) {

        cacheService.delete(key);

        return "Deleted Successfully";
    }
}
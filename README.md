# Mini Cache Engine

## Overview

Mini Cache Engine is a custom in-memory caching system built using Java and Spring Boot to understand the internal working of modern caching systems. Instead of relying on external solutions like Redis or Caffeine, this project implements core caching concepts from scratch.

The project demonstrates how an in-memory cache works, including data storage, expiration, statistics collection, thread-safe operations, and RESTful APIs for interacting with the cache.

This project was built as a learning-focused implementation of cache internals and backend system design concepts.

---

## Features

- Custom in-memory cache implementation
- Generic cache interface
- Thread-safe storage using `ConcurrentHashMap`
- Configurable Time-To-Live (TTL)
- Automatic cache expiration
- Scheduled cleanup of expired entries
- Cache hit and miss statistics
- Cache size monitoring
- REST APIs for cache operations
- Swagger/OpenAPI documentation
- Clean layered architecture
- Generic implementation using Java Generics

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web | REST APIs |
| Spring Scheduling | Automatic cleanup tasks |
| Maven | Dependency Management |
| Swagger / OpenAPI | API Documentation |

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.vishal.mini_cache
    │       ├── cache
    │       │   ├── Cache.java
    │       │   └── InMemoryCache.java
    │       │
    │       ├── config
    │       │   ├── CacheConfig.java
    │       │   └── OpenApiConfig.java
    │       │
    │       ├── controller
    │       │   └── CacheController.java
    │       │
    │       ├── dto
    │       │   ├── CacheRequest.java
    │       │   └── StatsResponse.java
    │       │
    │       ├── model
    │       │   ├── CacheEntry.java
    │       │   └── CacheStats.java
    │       │
    │       ├── service
    │       │   ├── CacheCleanupService.java
    │       │   └── CacheService.java
    │       │
    │       └── MiniCacheApplication.java
    │
    └── resources
```

---

## Architecture

```text
                Client
                   │
                   ▼
          CacheController
                   │
                   ▼
            CacheService
                   │
                   ▼
          Cache Interface
                   │
                   ▼
          InMemoryCache
                   │
                   ▼
         ConcurrentHashMap
```

---

## Cache Workflow

### Store

```text
Client
   │
POST /cache
   │
   ▼
CacheService
   │
   ▼
InMemoryCache
   │
   ▼
ConcurrentHashMap
```

### Retrieve

```text
GET /cache/{key}
        │
        ▼
Check Key
        │
   ┌────┴────┐
   │         │
Hit        Miss
   │         │
Return    Return null
Value
```

---

## Implemented Concepts

### In-Memory Storage

The cache stores all entries in memory using a thread-safe `ConcurrentHashMap`.

---

### Time-To-Live (TTL)

Every cache entry contains an expiration timestamp.

If the current time exceeds the expiry time, the entry is automatically considered invalid and removed.

---

### Cache Entry Metadata

Each cache entry stores:

- Value
- Creation Time
- Last Access Time
- Expiry Time
- Access Count

---

### Thread Safety

The cache uses `ConcurrentHashMap` to safely support concurrent read and write operations.

---

### Scheduled Cleanup

Expired cache entries are periodically removed using Spring Scheduler to prevent memory from being occupied by stale data.

---

### Cache Statistics

The cache maintains runtime statistics including:

- Cache Hits
- Cache Misses
- Hit Rate
- Cache Size

---

## REST API

### Store Value

```
POST /cache
```

Request

```json
{
  "key": "name",
  "value": "Vishal"
}
```

---

### Retrieve Value

```
GET /cache/{key}
```

Example

```
GET /cache/name
```

---

### Delete Value

```
DELETE /cache/{key}
```

Example

```
DELETE /cache/name
```

---

### Cache Size

```
GET /cache/size
```

---

### Cache Statistics

```
GET /cache/stats
```

Example Response

```json
{
  "hits": 15,
  "misses": 3,
  "evictions": 0,
  "hitRate": 83.33,
  "currentSize": 5
}
```

---

## Swagger Documentation

After running the application:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Specification:

```
http://localhost:8080/v3/api-docs
```

---

## Running the Project

### Clone Repository

```bash
git clone <repository-url>
```

---

### Navigate to Project

```bash
cd mini-cache
```

---

### Run

```bash
mvn spring-boot:run
```

or

Run `MiniCacheApplication.java` directly from your IDE.

---

## Learning Outcomes

This project demonstrates practical implementation of:

- Cache Design
- Thread-Safe Programming
- Generic Programming
- REST API Development
- Spring Boot
- Scheduled Background Tasks
- Cache Expiration Strategies
- Backend Architecture
- Interface-Based Design
- Concurrent Data Structures

---

## Future Enhancements

The following features can be implemented in future versions:

- LRU (Least Recently Used) Cache
- LFU (Least Frequently Used) Cache
- Cache Persistence
- Configurable TTL Per Entry
- Cache Event Listeners
- Distributed Cache
- Redis Integration
- Cache-Aside Pattern
- Metrics Dashboard
- Docker Support
- Unit and Integration Tests
- Benchmarking and Performance Analysis

---

## License

This project is intended for educational and learning purposes.

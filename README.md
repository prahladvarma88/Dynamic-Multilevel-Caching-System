# Dynamic Multilevel Caching System

## Overview

This project implements a dynamic multilevel caching system in Java. The system manages data across multiple cache levels with different eviction policies. It supports dynamic addition and removal of cache levels, efficient data retrieval and insertion, and a basic implementation of eviction policies.

## Components

1. **CacheEntry.java**: Defines a cache entry, tracking its value and access frequency (for LFU policy).
2. **CacheLevel.java**: Implements a single cache level with eviction policies (LRU or LFU).
3. **DynamicMultilevelCache.java**: Manages multiple cache levels, handling data retrieval, insertion, and dynamic level management.
4. **Main.java**: Contains sample test cases to demonstrate and verify the functionality of the caching system.

## Cache Levels

- **L1**: Highest priority cache level.
- **L2, L3, ...**: Lower priority cache levels.

## Eviction Policies

- **Least Recently Used (LRU)**: Evicts the least recently accessed item.
- **Least Frequently Used (LFU)**: Evicts the least frequently accessed item.

## Key Functions

1. `addCacheLevel(size: number, evictionPolicy: string): void`
   - Adds a new cache level with the specified size and eviction policy.
   
2. `removeCacheLevel(level: number): void`
   - Removes a cache level by specifying its index (L1, L2, ..., Ln).

3. `put(key: string, value: string): void`
   - Inserts a key-value pair into the L1 cache. Evicts items if necessary.

4. `get(key: string): string | null`
   - Retrieves the data corresponding to the key. Moves data up to higher cache levels if found in lower levels.

5. `displayCache(): void`
   - Prints the current state of each cache level, showing the keys and values.



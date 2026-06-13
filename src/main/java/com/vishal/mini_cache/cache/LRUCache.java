package com.vishal.mini_cache.cache;

import com.vishal.mini_cache.cache.lru.CacheNode;
import com.vishal.mini_cache.cache.lru.DoublyLinkedList;
import com.vishal.mini_cache.model.CacheEntry;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    private static final long DEFAULT_TTL = 60000;

    private final int capacity;

    private final Map<K, CacheNode<K, V>> storage;

    private final DoublyLinkedList<K, V> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    @Override
    public void put(K key, V value) {

        long now = System.currentTimeMillis();

        if (storage.containsKey(key)) {

            CacheNode<K, V> existingNode =
                    storage.get(key);

            CacheEntry<V> updatedEntry =
                    new CacheEntry<>(
                            value,
                            now,
                            now + DEFAULT_TTL
                    );

            existingNode.setEntry(updatedEntry);

            list.moveToEnd(existingNode);

            return;
        }

        if (storage.size() >= capacity) {

            CacheNode<K, V> lruNode =
                    list.getHead();

            if (lruNode != null) {

                list.remove(lruNode);

                storage.remove(
                        lruNode.getKey()
                );

                System.out.println(
                        "Evicted Key : "
                                + lruNode.getKey()
                );
            }
        }

        CacheEntry<V> entry =
                new CacheEntry<>(
                        value,
                        now,
                        now + DEFAULT_TTL
                );

        CacheNode<K, V> node =
                new CacheNode<>(key, entry);

        list.addLast(node);

        storage.put(key, node);
    }

    @Override
    public V get(K key) {

        CacheNode<K, V> node =
                storage.get(key);

        if (node == null) {
            return null;
        }

        CacheEntry<V> entry =
                node.getEntry();

        long now =
                System.currentTimeMillis();

        if (now > entry.getExpiryTime()) {

            list.remove(node);

            storage.remove(key);

            System.out.println(
                    "Expired Key : "
                            + key
            );

            return null;
        }

        entry.updateAccessMetadata();

        list.moveToEnd(node);

        return entry.getValue();
    }

    @Override
    public void remove(K key) {

        CacheNode<K, V> node =
                storage.remove(key);

        if (node != null) {
            list.remove(node);
        }
    }

    @Override
    public int size() {
        return storage.size();
    }
}
package com.vishal.mini_cache.cache.lru;

import lombok.Getter;

@Getter
public class DoublyLinkedList<K, V> {

    private CacheNode<K, V> head;

    private CacheNode<K, V> tail;

    public void addLast(CacheNode<K, V> node) {

        if (tail == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;

        tail = node;
    }

    public void moveToEnd(CacheNode<K, V> node) {

        if (tail == node) {
            return;
        }

        remove(node);

        addLast(node);
    }

    public void remove(CacheNode<K, V> node) {

        if (node == null) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (head == node) {
            head = node.next;
        }

        if (tail == node) {
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }
}
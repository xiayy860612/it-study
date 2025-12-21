package com.s2u2m.it_study.common.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/" />
 */
class LRUCache {
    private final List<Integer> keys = new LinkedList<>();
    private final Map<Integer, Integer> kvs = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!kvs.containsKey(key)) {
            return -1;
        }

        updateKey(key);
        return kvs.get(key);
    }

    public void put(int key, int value) {
        if (kvs.containsKey(key)) {
            updateKey(key);
            kvs.put(key, value);
            return;
        }

        kvs.put(key, value);
        keys.add(0, key);
        if (keys.size() > capacity) {
            Integer rmKey = keys.remove(keys.size() - 1);
            kvs.remove(rmKey);
        }
    }

    private void updateKey(int key) {
        keys.remove(Integer.valueOf(key));
        keys.add(0, key);
    }
}


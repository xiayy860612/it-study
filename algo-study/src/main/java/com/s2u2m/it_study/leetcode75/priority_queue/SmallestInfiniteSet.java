package com.s2u2m.it_study.leetcode75.priority_queue;

import java.util.PriorityQueue;
import java.util.TreeSet;

// https://leetcode.cn/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
public class SmallestInfiniteSet {
    private TreeSet<Integer> pq;
    private int threshhold;

    public SmallestInfiniteSet() {
        pq = new TreeSet<>();
        threshhold = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            return pq.pollFirst();
        }

        int ans = threshhold;
        ++threshhold;
        return ans;
    }

    public void addBack(int num) {
        if (num < threshhold) {
            pq.add(num);
        }
    }
}

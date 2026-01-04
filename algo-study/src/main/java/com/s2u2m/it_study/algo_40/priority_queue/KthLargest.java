package com.s2u2m.it_study.algo_40.priority_queue;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/" />
 */
public class KthLargest {
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        while (pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}

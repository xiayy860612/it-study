package com.s2u2m.it_study.leetcode75.priority_queue;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75
public class FindKthLargestSolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.element();
    }
}

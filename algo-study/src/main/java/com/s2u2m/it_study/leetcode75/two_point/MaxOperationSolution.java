package com.s2u2m.it_study.leetcode75.two_point;

import java.util.Arrays;

// https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
public class MaxOperationSolution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                ++count;
                ++l;
                --r;
            } else if (sum < k) {
                ++l;
            } else {
                --r;
            }
        }
        return count;
    }
}

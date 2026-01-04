package com.s2u2m.it_study.leetcode75.two_point;

// https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
public class LongestOnesSolution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int zeroCount = 0;
        int oneCount = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == 1) {
                oneCount = Math.max(oneCount, i - left + 1);
                continue;
            }

            ++zeroCount;
            if (zeroCount <= k) {
                oneCount = Math.max(oneCount, i - left + 1);
                continue;
            }

            while (zeroCount > k) {
                int start = nums[left];
                if (start == 0) {
                    --zeroCount;
                }
                ++left;
            }
        }
        return oneCount;
    }
}

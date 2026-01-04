package com.s2u2m.it_study.algo_40.others.dp;

// https://leetcode.cn/problems/maximum-product-subarray/
public class MaxProductSolution {

    private static record State(int min, int max) {}

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        State[] dp = new State[nums.length];
        dp[0] = new State(nums[0], nums[0]);

        int max = dp[0].max;
        for (int i = 1; i < nums.length; i++) {
            State state = getDp(dp[i - 1], nums[i]);
            dp[i] = state;
            max = Math.max(max, state.max);
        }
        return max;
    }

    private State getDp(State preState, int cur) {
        int value1 = preState.max * cur;
        int value2 = preState.min * cur;

        int max = Math.max(Math.max(value1, value2), cur);
        int min = Math.min(Math.min(value1, value2), cur);
        return new State(min, max);
    }
}

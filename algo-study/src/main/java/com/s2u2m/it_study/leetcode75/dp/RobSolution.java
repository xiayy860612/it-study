package com.s2u2m.it_study.leetcode75.dp;

// https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&envId=leetcode-75
public class RobSolution {
    private static record State(int maxTheft, int maxNoTheft) {}

    public int rob(int[] nums) {
        State[] dp = new State[nums.length];
        dp[0] = new State(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int theft = dp[i - 1].maxNoTheft + nums[i];
            int noTheft = Math.max(dp[i - 1].maxTheft, dp[i - 1].maxNoTheft);
            dp[i] = new State(theft, noTheft);
        }

        State state = dp[nums.length - 1];
        return Math.max(state.maxTheft, state.maxNoTheft);
    }
}

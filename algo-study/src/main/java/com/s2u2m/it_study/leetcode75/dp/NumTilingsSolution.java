package com.s2u2m.it_study.leetcode75.dp;

// https://leetcode.cn/problems/domino-and-tromino-tiling/?envType=study-plan-v2&envId=leetcode-75
public class NumTilingsSolution {
    private static record State(int filledCount, int noFilledCount) { }
    public int numTilings(int n) {
        int mod = 1000000007;
        int[][] dp = new int[n][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][3] % mod;
            dp[i][1] = (dp[i-1][2] + dp[i-1][0]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
            dp[i][3] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % mod;
        }

        return dp[n-1][3];
    }
}

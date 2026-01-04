package com.s2u2m.it_study.algo_40.others.dp;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/
public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = getMinSteps(dp, i, coins);
        }
        return dp[amount];
    }

    private int getMinSteps(int[] dp, int amount, int[] coins) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int pre = amount - coin;
            if (pre < 0 || dp[pre] == -1) {
                continue;
            }

            int steps = dp[pre] + 1;
            min = Math.min(min, steps);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int result = new CoinChangeSolution().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(result);
    }
}

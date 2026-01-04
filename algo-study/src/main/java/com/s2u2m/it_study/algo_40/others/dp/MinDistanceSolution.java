package com.s2u2m.it_study.algo_40.others.dp;

// https://leetcode.cn/problems/edit-distance/
public class MinDistanceSolution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            char w1c = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char w2c = word2.charAt(j - 1);
                if (w1c == w2c) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int replace = dp[i - 1][j - 1] + 1;
                int add = dp[i][j - 1] + 1;
                int del = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(replace, add), del);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

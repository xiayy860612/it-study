package com.s2u2m.it_study.algo_40.others.dp;

// https://leetcode.cn/problems/climbing-stairs/
public class ClimbStairsSolution {
    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}

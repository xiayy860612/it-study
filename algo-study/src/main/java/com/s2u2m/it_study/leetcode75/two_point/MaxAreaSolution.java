package com.s2u2m.it_study.leetcode75.two_point;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
public class MaxAreaSolution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int cur = getArea(height, l, r);
            max = Math.max(cur, max);

            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }

    private int getArea(int[] height, int l, int r) {
        int w = r - l;
        int h = Math.min(height[l], height[r]);
        return w * h;
    }
}

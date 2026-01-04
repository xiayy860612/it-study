package com.s2u2m.it_study.algo_40.others;

// 二分查找
// https://leetcode.cn/problems/sqrtx/
public class BinarySearchSolution {
    // 查找小于某个值中的最大值
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

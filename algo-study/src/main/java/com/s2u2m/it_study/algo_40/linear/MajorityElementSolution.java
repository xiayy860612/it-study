package com.s2u2m.it_study.algo_40.linear;

import java.util.Arrays;

// https://leetcode.cn/problems/majority-element/
public class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

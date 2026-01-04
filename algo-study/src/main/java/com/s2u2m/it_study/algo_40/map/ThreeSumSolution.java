package com.s2u2m.it_study.algo_40.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
public class ThreeSumSolution {

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSum(nums, i, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int target = -nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    ++left;
                }

                while (left < right && nums[right] == nums[right - 1]) {
                    --right;
                }

                ++left;
                --right;
                continue;
            }

            if (sum > target) {
                --right;
                continue;
            }

            ++left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSumSolution().threeSum2(nums);
        result.forEach(System.out::println);
    }
}

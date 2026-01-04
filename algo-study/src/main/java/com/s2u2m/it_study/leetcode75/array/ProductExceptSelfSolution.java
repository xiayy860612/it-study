package com.s2u2m.it_study.leetcode75.array;

// https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
public class ProductExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length + 1];
        pre[0] = 1;
        int[] suffix = new int[nums.length + 1];
        suffix[nums.length] = 1;

        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] * nums[i];

            int suffixIndex = nums.length - i - 1;
            suffix[suffixIndex] = suffix[suffixIndex + 1] * nums[suffixIndex];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = pre[i] * suffix[i + 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = new ProductExceptSelfSolution().productExceptSelf(nums);
        System.out.println(answer);
    }
}

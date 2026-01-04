package com.s2u2m.it_study.algo_40.others.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/longest-increasing-subsequence/
public class LengthOfLISSolution {
    private static record State(Deque<Integer> queue) { }

    public int lengthOfLIS(int[] nums) {
        if  (nums == null || nums.length == 0) return 0;

        State[] dp = new State[nums.length];
        dp[0] = new State(new ArrayDeque<>(List.of(nums[0])));

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            State cur = getState(dp, i, nums[i]);
            dp[i] = cur;
            max = Math.max(max, cur.queue.size());
        }
        return max;
    }

    private State getState(State[] dp, int curIndex, int cur) {
        Deque<Integer> max = new ArrayDeque<>();
        for (int i = 0; i < curIndex; i++) {
            State state = dp[i];
            if (state.queue.getLast() >= cur || state.queue.size() <= max.size()) {
                continue;
            }

            max = new ArrayDeque<>(state.queue);
        }
        max.addLast(cur);
        return new State(max);
    }
}

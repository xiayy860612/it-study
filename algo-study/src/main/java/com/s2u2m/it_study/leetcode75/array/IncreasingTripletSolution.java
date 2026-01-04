package com.s2u2m.it_study.leetcode75.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
public class IncreasingTripletSolution {

    private static record State(Deque<Integer> seq) {
        int getMax() {
            return seq.getLast();
        }

        int getLength() {
            return seq.size();
        }
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        State[] dp = new State[nums.length];
        dp[0] = new State(new ArrayDeque<>(List.of(nums[0])));

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            Deque<Integer> preSeq = new ArrayDeque<>();
            int maxLength = 0;
            for (int j = i - 1; j >= 0; --j) {
                State state = dp[j];
                if (state.getMax() >= cur || state.getLength() <= maxLength) {
                    continue;
                }

                preSeq = state.seq;
                maxLength = state.getLength();

                if (maxLength == 2) {
                    return true;
                }
            }

            ArrayDeque<Integer> seq = new ArrayDeque<>(preSeq);
            seq.addLast(cur);
            dp[i] = new State(seq);
        }
        return false;
    }
}

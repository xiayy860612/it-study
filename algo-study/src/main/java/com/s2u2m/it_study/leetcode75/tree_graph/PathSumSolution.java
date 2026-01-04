package com.s2u2m.it_study.leetcode75.tree_graph;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
public class PathSumSolution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Map<Long, Integer> preSums = new HashMap<>();
        preSums.put(0L, 1);
        return dfs(0L, root, targetSum, preSums);
    }

    private int dfs(Long preSum, TreeNode cur, int targetSum, Map<Long, Integer> preSums) {
        if (cur == null) {
            return 0;
        }

        long sum = preSum + cur.val;
        long rest = sum - targetSum;
        int match = preSums.getOrDefault(rest, 0);

        preSums.put(sum, preSums.getOrDefault(sum, 0) + 1);

        match += dfs(sum, cur.left, targetSum, preSums);
        match += dfs(sum, cur.right, targetSum, preSums);

        preSums.put(sum, preSums.get(sum) - 1);
        return match;
    }
}

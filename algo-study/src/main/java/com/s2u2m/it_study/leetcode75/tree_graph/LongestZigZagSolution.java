package com.s2u2m.it_study.leetcode75.tree_graph;

// https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
public class LongestZigZagSolution {
    public int longestZigZag(TreeNode root) {
        int[] max = new int[2];
        dfs(root, max);
        return Math.max(max[0], max[1]);
    }

    private int[] dfs(TreeNode node, int[] max) {
        if (node == null) {
            return new int[] {-1 , -1};
        }

        int[] rst = new int[2];
        int[] l = dfs(node.left, max);
        rst[0] = l[1] + 1;
        max[0] = Math.max(rst[0], max[0]);

        int[] r = dfs(node.right, max);
        rst[1] = r[0] + 1;
        max[1] = Math.max(rst[1], max[1]);

        return rst;
    }
}

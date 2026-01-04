package com.s2u2m.it_study.leetcode75.tree_graph;

// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
class GoodNodesSolution {

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        dfs(Integer.MIN_VALUE, root, result);
        return result[0];
    }

    private void dfs(int max, TreeNode node, int[] result) {
        if (node == null) {
            return;
        }

        if (max <= node.val) {
            result[0]++;
        }

        max = Math.max(max, node.val);

        dfs(max, node.left, result);
        dfs(max, node.right, result);
    }
}

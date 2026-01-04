package com.s2u2m.it_study.algo_40.tree;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/" />
 */
public class ValidateBinarySearchTreeSolution {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, Long min, Long max) {
        if (node == null) {
            return true;
        }

        Long val = (long) node.val;
        if (val <= min || val >= max) {
            return false;
        }

        return dfs(node.left, min, val) && dfs(node.right, val, max);
    }
}

package com.s2u2m.it_study.algo_40.tree;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfBinarySearchTreeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return dfs(root, q, p);
        }

        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode cur, TreeNode small, TreeNode big) {
        if (cur == null || cur == small || cur == big) {
            return cur;
        }

        if (cur.val > small.val && cur.val < big.val) {
            return cur;
        }

        if (cur.val < small.val) {
            return dfs(cur.right, small, big);
        }

        return dfs(cur.left, small, big);
    }


}

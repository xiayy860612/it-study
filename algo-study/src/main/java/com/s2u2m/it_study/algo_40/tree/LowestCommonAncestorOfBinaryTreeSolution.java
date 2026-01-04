package com.s2u2m.it_study.algo_40.tree;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTreeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode ln =  lowestCommonAncestor(root.left, p, q);
        TreeNode rn =  lowestCommonAncestor(root.right, p, q);
        if (ln != null && rn != null) {
            return root;
        }

        if (ln != null) {
            return ln;
        }

        return rn;
    }
}

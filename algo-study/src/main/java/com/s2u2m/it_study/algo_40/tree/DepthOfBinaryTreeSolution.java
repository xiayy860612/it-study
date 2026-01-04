package com.s2u2m.it_study.algo_40.tree;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class DepthOfBinaryTreeSolution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            ++maxDepth;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.remove();

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return maxDepth;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            ++depth;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.remove();

                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return depth;
    }
}

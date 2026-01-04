package com.s2u2m.it_study.algo_40.tree;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/" />
 */
public class BinaryTreeLevelOrderTraversalSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> layer = new ArrayList<>(count);
            while (count-- > 0) {
                TreeNode cur = queue.remove();
                layer.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(layer);
        }
        return result;
    }
}

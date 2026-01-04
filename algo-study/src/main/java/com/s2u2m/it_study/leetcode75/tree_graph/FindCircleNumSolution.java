package com.s2u2m.it_study.leetcode75.tree_graph;

// https://leetcode.cn/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
public class FindCircleNumSolution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 0 || isConnected[i][j] == 2) {
                    continue;
                }

                ++count;
                dfs(isConnected, i, j);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, int j) {
        if (i < 0 || i >= isConnected.length || j < 0 || j >= isConnected[i].length) {
            return;
        }

        if (isConnected[i][j] == 0 || isConnected[i][j] == 2) {
            return;
        }

        isConnected[i][j] = 2;

        for (int k = 0; k < isConnected.length; k++) {
            dfs(isConnected, i, k);
        }
    }
}

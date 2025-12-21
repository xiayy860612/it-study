package com.s2u2m.it_study.common.tree;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/" />
 */
public class NumberOfIslandsSolution {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '*') {
                    continue;
                }

                ++count;
                markIsland(grid, i, j);
            }
        }
        return count;
    }

    private void markIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == '0' || grid[i][j] == '*') {
            return;
        }

        grid[i][j] = '*';
        markIsland(grid, i + 1, j);
        markIsland(grid, i - 1, j);
        markIsland(grid, i, j + 1);
        markIsland(grid, i, j - 1);
    }
}

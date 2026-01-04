package com.s2u2m.it_study.algo_40.others.dp;

import java.util.List;

// https://leetcode.cn/problems/triangle/
public class TriangleSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int layerIndex = triangle.size() - 1;
        List<Integer> lastRow = triangle.get(layerIndex);
        int[] dp = new int[lastRow.size()];
        int i = 0;
        for (Integer v : lastRow) {
            dp[i++] = v;
        }
        --layerIndex;

        while (layerIndex >= 0) {
            List<Integer> row = triangle.get(layerIndex);
            for (int j = 0; j < row.size(); j++) {
                int cur = row.get(j);
                int v1 = dp[j] + cur;
                int v2 = dp[j + 1] + cur;
                dp[j] = Math.min(v1, v2);
            }
            --layerIndex;
        }
        return dp[0];
    }
}

package com.s2u2m.it_study.common.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/" />
 */
public class GenerateParenthesesSolution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("(", n, 1, 0, result);
        return result;
    }

    private void dfs(String cur, int n, int l, int r, List<String> result) {
        if (l == n && l == r) {
            result.add(cur);
            return;
        }

        if (l < r) {
            return;
        }

        if (l < n) {
            dfs(cur + "(", n, l + 1, r, result);
        }

        if (r < l) {
            dfs(cur + ")", n, l, r + 1, result);
        }
    }
}

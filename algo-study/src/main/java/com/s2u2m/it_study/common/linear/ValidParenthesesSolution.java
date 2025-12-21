package com.s2u2m.it_study.common.linear;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <a href="https://leetcode.cn/problems/valid-parentheses/" />
 */
public class ValidParenthesesSolution {

    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('}', '{', ']', '[', ')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                Character expect = map.get(c);
                Character left = stack.remove();
                if (!expect.equals(left)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

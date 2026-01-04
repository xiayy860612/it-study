package com.s2u2m.it_study.leetcode75.array;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
public class ReverseWordsSolution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();

        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            ++start;
        }

        int end = start;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (c != ' ') {
                ++end;
                continue;
            }

            String word = getWord(s, start, end - 1);
            stack.addLast(word);

            while (end < s.length() && s.charAt(end) == ' ') {
                ++end;
            }

            start = end;
            ++end;
        }

        if (start < s.length()) {
            String word = getWord(s, start, end - 1);
            stack.addLast(word);
        }

                                                                                                                                                                                                         StringBuilder sb = new StringBuilder();
        if (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        while (!stack.isEmpty()) {
            sb.append(' ');
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    private String getWord(String s, int start, int end) {
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        String s = "  hello world  ";
        String result = new ReverseWordsSolution().reverseWords(s);
        System.out.println(result);
    }
}

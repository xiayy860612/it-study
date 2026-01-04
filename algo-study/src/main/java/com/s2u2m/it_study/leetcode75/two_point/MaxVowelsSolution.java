package com.s2u2m.it_study.leetcode75.two_point;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

// https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
public class MaxVowelsSolution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Deque<Character> queue = new ArrayDeque<>();
        int vowelCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            queue.addLast(c);
            if (vowels.contains(c)) {
                ++vowelCount;
            }

            while (queue.size() > k) {
                Character removed = queue.removeFirst();
                if (vowels.contains(removed)) {
                    --vowelCount;
                }
            }
            max = Math.max(max, vowelCount);
        }
        return max;
    }

    public static void main(String[] args) {
        int result = new MaxVowelsSolution().maxVowels("abciiidef", 3);
        System.out.println(result);
    }
}

package com.s2u2m.it_study.algo_40.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/" />
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> stat = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = stat.getOrDefault(c, 0);
            stat.put(c, count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = stat.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }

            if (count == 1) {
                stat.remove(c);
            } else {
                stat.put(c, count - 1);
            }
        }

        return stat.isEmpty();
    }
}

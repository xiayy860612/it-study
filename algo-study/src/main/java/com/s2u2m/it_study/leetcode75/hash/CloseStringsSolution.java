package com.s2u2m.it_study.leetcode75.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
public class CloseStringsSolution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> word1Stat = new HashMap<>();
        stat(word1Stat, word1);
        Map<Character, Integer> word2Stat = new HashMap<>();
        stat(word2Stat, word2);

        Set<Character> w1Keys = word1Stat.keySet();
        Set<Character> w2Keys = word2Stat.keySet();
        if (!w1Keys.equals(w2Keys)) {
            return false;
        }

        List<Integer> w1Values = word1Stat.values().stream().sorted().toList();
        List<Integer> w2Values = word2Stat.values().stream().sorted().toList();
        for (int i = 0; i < w1Values.size(); i++) {
            Integer v1 = w1Values.get(i);
            Integer v2 = w2Values.get(i);
            if (!v1.equals(v2)) {
                return false;
            }
        }
        return true;
    }

    private void stat(Map<Character, Integer> stat, String word) {
        for (char c : word.toCharArray()) {
            int origin = stat.getOrDefault(c, 0);
            stat.put(c, origin + 1);
        }
    }
}

package com.s2u2m.it_study.leetcode75.binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
public class SuccessfulPairsSolution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        Map<Integer, Integer> stat = new HashMap<>();
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int cur = spells[i];
            if (stat.containsKey(cur)) {
                result[i] = stat.get(cur);
                continue;
            }

            int count = getSuccessCount(cur, potions, success);
            result[i] = count;
            stat.put(cur, count);
        }
        return result;
    }

    private int getSuccessCount(int cur, int[] potions, long success) {
        int l = 0;
        int r = potions.length - 1;
        int min = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int potion = potions[mid];
            int value = cur * potion;
            if (value < success) {
                l = mid + 1;
            } else {
                min = mid;
                r = mid - 1;
            }
        }
        return potions.length - min;
    }
}

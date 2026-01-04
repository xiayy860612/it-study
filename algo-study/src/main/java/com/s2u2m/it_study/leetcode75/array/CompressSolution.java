package com.s2u2m.it_study.leetcode75.array;

// https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
public class CompressSolution {
    public int compress(char[] chars) {
        int charIndex = 0;
        int writeIndex = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == chars[charIndex]) {
                ++i;
                continue;
            }

            int count = i - charIndex;
            writeIndex = override(chars, writeIndex, chars[charIndex], count);
            charIndex = i;
            ++i;
        }

        int count = i - charIndex;
        writeIndex = override(chars, writeIndex, chars[charIndex], count);

        return writeIndex;
    }

    private int override(char[] chars, int writeIndex, char c, int count) {
        chars[writeIndex++] = c;
        if (count == 1) {
            return writeIndex;
        }

        char[] countChars = String.valueOf(count).toCharArray();
        for (char countChar : countChars) {
            chars[writeIndex++] = countChar;
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'a','a','b','b','c','c','c'};
        int len = new CompressSolution().compress(chars);
        System.out.println(len);
    }
}

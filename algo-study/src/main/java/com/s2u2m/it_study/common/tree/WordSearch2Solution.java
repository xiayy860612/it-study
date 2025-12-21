package com.s2u2m.it_study.common.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/word-search-ii/" />
 */
public class WordSearch2Solution {
    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isWord;

        public TrieNode() {
            isWord = false;
        }

        public void addWord(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        public TrieNode prefixSearch(String prefix) {
            TrieNode node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

        public TrieNode searchNextNode(Character c) {
            int index = c - 'a';
            return children[index];
        }

        public boolean isWord() {
            return isWord;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.addWord(word);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs("", board, i, j, trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(String pre, char[][] board, int i, int j, TrieNode parent, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#') {
            return;
        }

        TrieNode node = parent.searchNextNode(c);
        if (node == null) {
            return;
        }

        String cur = pre + c;
        if (node.isWord) {
            result.add(cur);
        }

        board[i][j] = '#';

        dfs(cur, board, i + 1, j, node, result);
        dfs(cur, board, i - 1, j, node, result);
        dfs(cur, board, i, j + 1, node, result);
        dfs(cur, board, i, j - 1, node, result);

        board[i][j] = c;
    }
}

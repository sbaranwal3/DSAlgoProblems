package challenge.leetcode.july;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch {
    private static boolean dfs(char[][] board, int i, int j, Trie trie, String s) {
        char c = board[i][j];
        if (c == '$')
            return false;
        board[i][j] = '$';
        Trie t = trie.children[c - 'a'];
        if (t != null) {
            String ss = s + c;
            if (t.isEndOfWord) return true;
            if (i < board.length - 1)
                dfs(board, i + 1, j, t, ss);
            if (j < board[0].length - 1)
                dfs(board, i, j + 1, t, ss);
            if (i > 0)
                dfs(board, i - 1, j, t, ss);
            if (j > 0)
                dfs(board, i, j - 1, t, ss);
        }
        board[i][j] = c;
        return false;
    }

    public static class Trie {
        Trie children[];
        boolean isEndOfWord;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEndOfWord = false;
            children = new Trie[100];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null)
                    current.children[c - 'a'] = new Trie();
                current = current.children[c - 'a'];
            }
            current.isEndOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                current = current.children[c - 'a'];
                if (current == null)
                    return false;
            }
            if (current.isEndOfWord)
                return true;
            return false;
        }
    }
    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        Trie trie = new Trie();
            trie.insert(word);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, "");
            }
        }

        return false;
}

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Does word exist? "+exist(board, word));
    }
}

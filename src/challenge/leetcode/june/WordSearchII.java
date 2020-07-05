package challenge.leetcode.june;
/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
   Hide Hint #1
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
   Hide Hint #2
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 What kind of data structure could answer such query efficiently?
 Does a hash table work? Why or why not? How about a Trie?
  If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    private static void dfs(char[][] board, int i, int j, HashSet<String> result, Trie trie, String s) {
        char c = board[i][j];
        if (c == '$')
            return;
        board[i][j] = '$';
        Trie t = trie.children[c - 'a'];
        if (t != null) {
            String ss = s + c;
            if (t.isEndOfWord) result.add(ss);
            if (i < board.length - 1)
                dfs(board, i + 1, j, result, t, ss);
            if (j < board[0].length - 1)
                dfs(board, i, j + 1, result, t, ss);
            if (i > 0)
                dfs(board, i - 1, j, result, t, ss);
            if (j > 0)
                dfs(board, i, j - 1, result, t, ss);
        }
        board[i][j] = c;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0)
            return new ArrayList<>();
        Trie trie = new Trie();
        for (String w : words)
            trie.insert(w);

        HashSet<String> hashSet = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, hashSet, trie, "");
            }
        }
        ArrayList<String> result = new ArrayList(hashSet);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println("Words present in the board are: " + Arrays.toString(findWords(board, words).toArray()));
    }

    public static class Trie {
        Trie children[];
        boolean isEndOfWord;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEndOfWord = false;
            children = new Trie[26];
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
}

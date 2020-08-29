package challenge.leetcode.august;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

   Hide Hint #1
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */


class WordDictionary {
    WordDictionary children[];
    boolean isEndOfWord;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        isEndOfWord = false;
        children = new WordDictionary[26];
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordDictionary current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new WordDictionary();
            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        WordDictionary current = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary ch : current.children) {
                    if (ch != null && ch.search(word.substring(i + 1)))
                        return true;
                }
            }
            if (current.children[c - 'a'] == null)
                return false;
            current = current.children[c - 'a'];
        }
        if (current.isEndOfWord)
            return true;
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search("."));
        System.out.println(wd.search("a"));
        System.out.println(wd.search("aa"));
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

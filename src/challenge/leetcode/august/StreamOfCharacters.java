//package challenge.leetcode.august;
//
///*
//Implement the StreamChecker class as follows:
//
//StreamChecker(words): Constructor, init the data structure with the given words.
//query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
//
//
//Example:
//
//StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
//streamChecker.query('a');          // return false
//streamChecker.query('b');          // return false
//streamChecker.query('c');          // return false
//streamChecker.query('d');          // return true, because 'cd' is in the wordlist
//streamChecker.query('e');          // return false
//streamChecker.query('f');          // return true, because 'f' is in the wordlist
//streamChecker.query('g');          // return false
//streamChecker.query('h');          // return false
//streamChecker.query('i');          // return false
//streamChecker.query('j');          // return false
//streamChecker.query('k');          // return false
//streamChecker.query('l');          // return true, because 'kl' is in the wordlist
//
//
//Note:
//
//1 <= words.length <= 2000
//1 <= words[i].length <= 2000
//Words will only consist of lowercase English letters.
//Queries will only consist of lowercase English letters.
//The number of queries is at most 40000.
//   Hide Hint #1
//Put the words into a trie, and manage a set of pointers within that trie.
// */
//
//public class StreamOfCharacters {
//    Map<Character,TrieNode> mp;
//    boolean end_of_word;
//    TrieNode(){
//        mp=new HashMap<Character,TrieNode>();
//        end_of_word=false;
//    }
//
//    public void insertWordRev(String w){
//        int len=w.length();
//        TrieNode t=this;
//        for(int i=len-1;i>=0;i--){
//            char c=w.charAt(i);
//            if(!t.mp.containsKey(c)){
//                t.mp.put(c,new TrieNode());
//            }
//            t=t.mp.get(c);
//        }
//        t.end_of_word=true;
//    }
//}
//
//class StreamChecker {
//    TrieNode root;
//    String str;
//
//    public StreamChecker(String[] words) {
//        root=new TrieNode();
//        for(String w:words){
//            root.insertWordRev(w);
//        }
//    }
//
//    public boolean query(char letter) {
//        str+=letter;
//        int len=str.length();
//        TrieNode temp=root;
//        for(int i=len-1;i>=0;i--){
//            char c=str.charAt(i);
//            if(temp.end_of_word){
//                return true;
//            }
//            if(!temp.mp.containsKey(c)){
//                return false;
//            }
//            temp=temp.mp.get(c);
//        }
//        return temp.end_of_word;
//    }
//}

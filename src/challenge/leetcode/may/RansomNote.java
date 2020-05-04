package challenge.leetcode.may;

import java.util.HashMap;
import java.util.Map;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
 write a function that will return true if the ransom note can be constructed from the magazines ;
  otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    //O(n) time complexity and O(n) space
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        Map<Character, Integer> magMap = new HashMap<>();
        for (Character m : magazine.toCharArray()) {
            magMap.put(m, magMap.getOrDefault(m, 0) + 1);
        }
        for (Character r : ransomNote.toCharArray()) {
            if(magMap.getOrDefault(r,0)==0)
                return false;
            magMap.put(r, magMap.getOrDefault(r,0) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println("Can ransome note be constructed from the magazine? " + canConstruct(ransomNote, magazine));
    }
}

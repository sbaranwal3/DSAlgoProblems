package challenge.leetcode.may;

/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */

public class PermutationInAString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] charMap = new int[26];
        for (int i = 0; i < s1.length(); i++)
            charMap[s1.charAt(i) - 'a'] += 1;

        int wStart = 0;
        int wEnd = 0;
        while (wEnd < s2.length()) {
            // valid anagram
            if (charMap[s2.charAt(wEnd) - 'a'] > 0) {
                charMap[s2.charAt(wEnd++) - 'a']--;
                // window size equal to size of P
                if (wEnd - wStart == s1.length()) {
                    return true;
                }
            }
            // window is of size 0
            else if (wStart == wEnd) {
                wStart++;
                wEnd++;
            }
            // decrease window size
            else {
                charMap[s2.charAt(wStart++) - 'a']++;
            }
        }
        return false;
    }

    public static boolean checkInclusionApproach2(String s1, String s2){
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaoooo";
        System.out.println("Is first string's permutation, a substring of second string? "+checkInclusion(s1, s2));
    }
}

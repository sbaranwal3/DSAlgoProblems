package challenge.leetcode.may;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.*;

public class FindAllAnagramsInAString {
    //Sliding window approach
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length())
            return result;
        int[] pChars = new int[26];
        for (int i = 0; i < p.length(); i++)
            pChars[p.charAt(i) - 'a'] += 1;
        int start = 0;
        for (int i = 0; i < p.length(); i++)
            pChars[s.charAt(i) - 'a'] -= 1;
        int mismatchCount = 0;
        for (int pc : pChars) {
            if (pc != 0) {
                mismatchCount += 1;
            }
        }
        if (mismatchCount == 0)
            result.add(start);
        start++;
        while (start <= s.length() - p.length()) {
            int idx1 = s.charAt(start - 1) - 'a';
            int idx2 = s.charAt(start + p.length() - 1) - 'a';
            pChars[idx1] += 1;
            if (pChars[idx1] == 1)
                mismatchCount += 1;
            else if (pChars[idx1] == 0)
                mismatchCount -= 1;

            pChars[idx2] -= 1;
            if (pChars[idx2] == -1)
                mismatchCount += 1;
            else if (pChars[idx2] == 0)
                mismatchCount -= 1;

            if (mismatchCount == 0)
                result.add(start);
            start++;
        }
        return result;
    }


    //Sliding window approach improvised
    public static List<Integer> findAnagramsApproach2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        int[] pChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
        }

        int wStart = 0;
        int wEnd = 0;
        while (wEnd < s.length()) {
            // valid anagram
            if (pChars[s.charAt(wEnd) - 'a'] > 0) {
                pChars[s.charAt(wEnd++) - 'a']--;
                // window size equal to size of P
                if (wEnd - wStart == p.length()) {
                    result.add(wStart);
                }
            }
            // window is of size 0
            else if (wStart == wEnd) {
                wStart++;
                wEnd++;
            }
            // decrease window size
            else {
                pChars[s.charAt(wStart++) - 'a']++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("List of starting indices of " + p + "'s anagram in " + s + " are " + Arrays.toString(findAnagrams(s, p).toArray()));
        System.out.println("List of starting indices of " + p + "'s anagram in " + s + " are " + Arrays.toString(findAnagramsApproach2(s, p).toArray()));
    }
}

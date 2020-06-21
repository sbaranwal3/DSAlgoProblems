package challenge.leetcode.june;

/*
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)



Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""


Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.
   Hide Hint #1
Binary search for the length of the answer. (If there's an answer of length 10, then there are answers of length 9, 8, 7, ...)
   Hide Hint #2
To check whether an answer of length K exists, we can use Rabin-Karp 's algorithm.
 */

import java.util.HashSet;

public class LongestDuplicateSubstring {
    public static String longestDupSubstring(String S) {
        int lo = 1;
        int hi = S.length();
        while (lo != hi) {
            int mi = lo + (hi - lo) / 2;
            if (possible(S, mi) != -1)
                lo = mi + 1;
            else
                hi = mi;
        }
        int start = possible(S, lo - 1);
        return start != -1 ? S.substring(start, start + lo - 1) : "";
    }

    public static int possible(String s, int len) {
        long hash = 0;
        int a = 26;
        int n = s.length();
        final long mod = (long)Math.pow(2, 32);
        for(int i = 0; i < len; ++i)
            hash = (hash * a + (s.charAt(i)-'a')) % mod;

        HashSet<Long> set = new HashSet();
        set.add(hash);
        long global = 1;
        for (int i = 0; i < len; ++i)
            global = (global * a) % mod;

        for(int start = 1; start < n - len + 1; ++start) {
            hash = (hash * a - (s.charAt(start - 1)-'a') * global % mod + mod) % mod;
            hash = (hash + (s.charAt(start + len - 1)-'a')) % mod;
            if (set.contains(hash)) return start;
            set.add(hash);
        }
        return -1;

    }

    public static void main(String[] args) {
        String S = "shubham";
       // String S = "banana";
        System.out.println("Longest duplicate substring is: "+longestDupSubstring(S));
    }
}

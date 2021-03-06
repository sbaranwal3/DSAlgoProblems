package challenge.leetcode.june;

/*
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.
 */

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;
        if (s.length() > t.length())
            return false;
        int i = 0, j = 0;
        while(i < s.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static boolean isSubsequenceApproach2(String s, String t) {
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;
        if (s.length() > t.length())
            return false;
        int idx = -1;
        for (char c : s.toCharArray()){
            idx = t.indexOf(c, idx + 1);
            if (idx == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println("Is "+s+ " a subsequence of "+t+"? "+isSubsequence(s,t));
        System.out.println("Is "+s+ " a subsequence of "+t+" using approach2? "+isSubsequenceApproach2(s,t));
    }
}

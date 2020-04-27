package challenge.leetcode.days.thirty;
/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



If there is no common subsequence, return 0.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 */

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m==0 || n==0)
            return 0;
        //Using dynamic programming
        //Construct a 2d array of length [m+1][n+1] and initialize all of them with 0;
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //Whenever the characters are same at [i-1][j-1], Add 1 to the lcs of [i-1][j-1] in lcs[i][j]
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                //Else take the max of lcs[i-1][j] & lcs[i][j-1]
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        return lcs[m][n];

    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Length of the longest common subsequence is: " + longestCommonSubsequence(text1, text2));
    }
}

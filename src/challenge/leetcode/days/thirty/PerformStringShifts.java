package challenge.leetcode.days.thirty;

/*
You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.



Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"


Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
 */

public class PerformStringShifts {

    public static String stringShift(String s, int[][] shift) {
        int shiftCount = 0;
        //Calculate the net no. of shifts by considering left shift as 1 and right shift as -1
        // and then shift towards left or right based on the shiftCount being positive or negative
        for (int i = 0; i < shift.length; i++) {
            shiftCount += shift[i][0] == 0 ? shift[i][1] : -shift[i][1];
        }
        //Handle scenarios where shiftCOunt exceeds string length, in that case take the remainder of
        // shiftCount%s.length as that's the actualShift needed
        if(Math.abs(shiftCount)> s.length()){
            shiftCount = shiftCount%s.length();
        }
        //if shiftCount>0, leftShift by that count else rightShift by that count
        //for left shift, shiftCount remains shiftCount where as for rightShift, shiftCount will be s.length()-abs(shiftCount))
        return shiftCount > 0 ? rotate(s, shiftCount) : rotate(s, s.length() + shiftCount);

    }

    //rotate method to shift characters in the string
    static String rotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }


    public static void main(String[] args) {
        String s = "xqgwkiqpif";
        int[][] shift = {{1,4},{0,7},{0,8},{0,7},{0,6},{1,3},{0,1},{1,7},{0,5},{0,6}};
        System.out.println("String after perfroming shifts is: " + stringShift(s, shift));
    }
}

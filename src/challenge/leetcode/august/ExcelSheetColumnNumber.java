package challenge.leetcode.august;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701


Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".
 */

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int d= (s.charAt(i) - 'A' + 1);
            res += d * Math.pow(26, s.length() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ZZZZZ";
        System.out.println(titleToNumber(s));
    }

}

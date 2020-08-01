package challenge.leetcode.july;

/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?

   Hide Hint #1
A naive implementation of the above process is trivial. Could you come up with other methods?
   Hide Hint #2
What are all the possible results?
   Hide Hint #3
How do they occur, periodically or randomly?
   Hide Hint #4
You may find this Wikipedia article useful.
 */

public class AddDigits {
    public static int addDigits(int num) {
        if(num==0) return num;
        return num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        int num = 12435;
        System.out.println("Digit root of the given number is: "+addDigits(num));
    }
}

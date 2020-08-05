package challenge.leetcode.august;

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
 */

public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num % 3 == 1) && (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Is the given number a power of 4? " + isPowerOfFour(num));
    }
}

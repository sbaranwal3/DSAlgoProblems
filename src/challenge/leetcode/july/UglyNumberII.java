package challenge.leetcode.july;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
   Hide Hint #1
The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
   Hide Hint #2
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
   Hide Hint #3
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
   Hide Hint #4
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */

public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        int[] uglyList = new int[n];
        uglyList[0] = 1;
        int count = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        while (count < n) {
            int next2 = uglyList[idx2] * 2;
            int next3 = uglyList[idx3] * 3;
            int next5 = uglyList[idx5] * 5;
            int next = Math.min(Math.min(next2, next3), next5);
            uglyList[count++] = next;
            if (next == next2)
                idx2++;
            if (next == next3)
                idx3++;
            if (next == next5)
                idx5++;
        }

        return uglyList[n - 1];

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Nth ugly number is: " + nthUglyNumber(n));
    }
}

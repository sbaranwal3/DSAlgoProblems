package challenge.leetcode.may;

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
   Hide Hint #1
You should make use of what you have produced already.
   Hide Hint #2
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
   Hide Hint #3
Or does the odd/even status of the number help you in calculating the number of 1s?
 */

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int num) {
        //For any given number, the no. of 1's in it's binary representation is
        // same as the no. of bits in half the number
        // if even and no.of bits in half the number +1 if odd. This is due to the right shift operator which shifts
        // the msb by 1 towards right and hence the lsb is removed. For even no.s, lsb being 0,
        // it remains same as that of num>>1. For odd no.s, the last 1 needs to be added
        int[] bitCounts = new int[num + 1];
        for (int i = 1; i <= num; i++)
            bitCounts[i] = bitCounts[i >> 1] + i % 2;
        return bitCounts;
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println("No. of bits in their binary representation is for the given number is: " + Arrays.toString(countBits(num)));
    }
}

package challenge.leetcode.july;

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

import java.util.Arrays;

public class SingleNumberIII {

    //Brian Kerningham Algorithm

    public static int[] singleNumber(int[] nums) {
        int xy = 0;
        for (int n : nums) xy ^= n;
        xy &= -xy;
        int[] result = new int[2];
        for (int n : nums) {
            if ((xy & n) == 0) result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println("Single numbers are: " + Arrays.toString(singleNumber(nums)));
    }
}

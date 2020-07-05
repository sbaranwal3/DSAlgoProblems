package challenge.leetcode.june;

/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos = twos | (ones & nums[i]);
            ones = ones ^ nums[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Element which is occuring once is: " + singleNumber(nums));
    }
}

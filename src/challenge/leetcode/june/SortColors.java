package challenge.leetcode.june;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        //Dutch National Flag problem
        //Solved by using quick Sort algorithm where pivot is already defined and is 1
        //When encountering a 0, swap it with first element and increment p0 & counter
        //When encountering a 2, swap it with last elment and decrement p2
        //When encountering a 1, do nothing and just increment the counter
        int i = 0, p0 = 0;
        int p2 = nums.length - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                p0++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2] = 2;
                p2--;
            } else
                i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

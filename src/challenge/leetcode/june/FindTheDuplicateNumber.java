package challenge.leetcode.june;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int currMax = 0;
        for (int i = 0; i < n; i++) {
            int id = nums[i] % n;
            nums[id] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > currMax) {
                currMax = nums[i];
                maxIdx = i;
            }
            nums[i] %= n;
        }
        return maxIdx;
    }

    public static int findDuplicateApproach2(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            if (idx == nums[idx]) {
                idx++;
            } else {
                int temp;
                temp = nums[idx];
                if (nums[idx] == nums[temp]) {
                    return nums[idx];
                }
                nums[idx] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 2, 3, 4};
        System.out.println("Duplicate number in the given array is: " + findDuplicate(nums));
        System.out.println("Duplicate number in the given array using approach2 is: " + findDuplicateApproach2(nums));
    }
}

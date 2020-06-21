package challenge.leetcode.june;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1])
            return nums.length;
        if (target < nums[0])
            return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int target = 2;
        System.out.println("Index of the target is: " + searchInsert(nums, target));
    }
}
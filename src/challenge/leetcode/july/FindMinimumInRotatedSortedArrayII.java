package challenge.leetcode.july;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 */

public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int l = 0;
        int h = n - 1;
        //Step1: Find the min element index(pivot index)
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[h])
                l = mid + 1;
            else if (nums[mid] < nums[h])
                h = mid;
            else
                h--;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        System.out.println("Min element is: " + findMin(nums));
    }
}

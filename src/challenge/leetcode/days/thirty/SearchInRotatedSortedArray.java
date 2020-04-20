package challenge.leetcode.days.thirty;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int l = 0;
        int h = n - 1;
        //Step1: FInd the min element index(pivot index)
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[h])
                l = mid + 1;
            else
                h = mid;
        }
        //After actual low & high pivots are determined, call binarySearch algorithm
        if (target <= nums[n - 1])
            return binarySearch(nums, l, n-1, target);
        else
            return binarySearch(nums, 0, l-1, target);

    }

    static int binarySearch(int nums[], int l, int h, int target)
    {
        while(l<=h) {
                int mid = l + (h - l) / 2; //(l+h)/2
// If the element is present at the middle itself
                if (nums[mid] == target)
                    return mid;
// If element is smaller than mid, then it can only be present in left subarray
                if (nums[mid] > target)
                    h = mid-1;
// Else the element can only be present in right subarray
                else
                    l=mid+1;
        }
// We reach here when element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        int nums[]= {4,5,0};
        System.out.println("The target is at index: "+search(nums, 5));
    }

}


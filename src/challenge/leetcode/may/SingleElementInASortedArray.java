package challenge.leetcode.may;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.
 */

public class SingleElementInASortedArray {

    //Time complexity O(logn), space O(1)
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            //Since all the elements except singleElement appear twice, singleElement will always appear on the even index!
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1])
                    h = mid - 2;
                else if (nums[mid] == nums[mid + 1])
                    l = mid + 2;
                else
                    return nums[mid];
            }
            //If mid appears at odd index, just update the low and high index for further searches
            else {
                //In this case, since mid = mid-1, all the no.s appearing till mid will be even
                if (nums[mid] == nums[mid - 1])
                    l = mid + 1;
                //else, it lies in the left side as nums including mid+1 is even
                else
                    h = mid - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println("Single non-duplicate number in the array is: " + singleNonDuplicate(nums));
    }
}

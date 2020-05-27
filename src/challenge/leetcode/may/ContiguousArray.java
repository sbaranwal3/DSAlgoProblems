package challenge.leetcode.may;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */

import java.util.HashMap;

public class ContiguousArray {

    //Solution using hashMap with O(n) space & time complexity
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        //Iterate over the array and update the sum by considering 0 as -1 and 1 as 1 so that net sum is 0 whenever there are equal numbers of 0s & 1s.
        for (int i=0; i<nums.length; i++) {
            sum += (nums[i] == 0 ? -1 :1);

            //if sum is 0, update maxLength value as current pointer+1, signifying the length of array till now
            if (sum == 0)
                maxLength = i + 1;

            //Put the sum and index combo in a hashMap so that if the same sum is encountered,
            // maxLength can be replaced with current index-sum value
            //else put the new sum & the index
            if (hMap.containsKey(sum))
                maxLength = Math.max(maxLength, i - hMap.get(sum));
            else
                hMap.put(sum, i);
        }

        //finally return the maxLength
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,0,1};
        System.out.println("Longest contiguous subarray with equal nuber of 0s & 1s is: "+findMaxLength(nums));
    }
}

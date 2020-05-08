package challenge.leetcode.may;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        double halfSize = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > halfSize)
                return num;
        }
        return 0;
    }

    //Approach2: Sorting
    public static int majorityElementApproach2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Approach3: Boyer-Moore Voting Algorithm
    public static int majorityElementApproach3(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        //   System.out.println("The majority element in the array is: " + majorityElement(nums));
        //   System.out.println("The majority element in the array using sorting is: " + majorityElementApproach2(nums));
        System.out.println("The majority element in the array using  Boyer-Moore Voting Algorithm is: " + majorityElementApproach3(nums));
    }
}

package challenge.leetcode.days.thirty;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
import java.util.HashMap;

public class SubarraySumEqualsK {

    //Time complexity O(n), space complexity O(n)
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        //Create a HashMap of sum & it's count with initialized value as 0 & 1
        HashMap < Integer, Integer > map = new HashMap< >();
        //If sum==k, sum-k will be 0. Update the map with 0,1 beforehand
        map.put(0, 1);
        //Iterate over the array and update count with the sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            //Using getOrDefault value to avoid contains check
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //Time complexity O(n2), space complexity O(1)
    public static int subarraySumWithoutSpace(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,2,-1};
        int k =2;
        System.out.println("Number of continuous subarrays with sum: "+k+" using HashMap are: "+subarraySum(nums,k));
        System.out.println("Number of continuous subarrays with sum: "+k+" without using any space are: "+subarraySumWithoutSpace(nums,k));
    }
}

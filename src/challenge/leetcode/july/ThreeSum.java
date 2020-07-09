package challenge.leetcode.july;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
   Hide Hint #1
So, we essentially need to find three numbers x, y, and z such that they add up to the given value.
 If we fix one of the numbers say x, we are left with the two-sum problem at hand!
   Hide Hint #2
For the two-sum problem, if we fix one of the numbers, say
x
, we have to scan the entire array to find the next number
y
which is
value - x
where value is the input parameter. Can we change our array somehow so that this search becomes faster?
   Hide Hint #3
The second train of thought for two-sum is, without changing the array, can we use additional space somehow?
 Like maybe a hash map to speed up the search?
 */

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        Collections.sort(set);
                        if(!result.contains(set))
                        result.add(set);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumApp2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n<3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                int j=i+1, k=n-1;
                while(j<k){
                    int sum = nums[i] + nums[j]+ nums[k];
                    if(sum==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1]) j++;
                        while(j<k && nums[k]==nums[k-1]) k--;
                        j++; k--;
                    } else if(sum>0) k--;
                    else j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> sol = threeSum(nums);
        System.out.println("Set of three numbers with sum 0 are: ");
        for (List<Integer> s : sol)
            System.out.println(Arrays.toString(s.toArray()));

        List<List<Integer>> sol2 = threeSumApp2(nums);
        System.out.println("Set of three numbers with sum 0 are: ");
        for (List<Integer> s : sol2)
            System.out.println(Arrays.toString(s.toArray()));
    }
}

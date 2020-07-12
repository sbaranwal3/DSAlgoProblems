package challenge.leetcode.july;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0)
            return result;
        for (int num: nums) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> r = new ArrayList<>(result.get(j));
                r.add(num);
                result.add(r);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 12,14};

        for (List<Integer> set : subsets(nums)) {
            System.out.println(Arrays.toString(set.toArray()));
        }
    }

}

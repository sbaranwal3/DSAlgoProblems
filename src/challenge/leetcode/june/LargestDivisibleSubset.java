package challenge.leetcode.june;

/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0)
            return result;

        Arrays.sort(nums);
        int[] nextIdx = new int[n];
        int[] sizes = new int[n];
        Arrays.fill(nextIdx, -1);
        Arrays.fill(sizes, 1);
        int maxLen = 1;
        int maxIndex = 0;

        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            int max = 0;
            int maxIdx = i;
            while (j < n) {
                if (nums[j] % nums[i] == 0 && sizes[j] > max) {
                    max = sizes[j];
                    maxIdx = j;
                }
                j++;
            }
            if (maxIdx != i) {
                sizes[i] += sizes[maxIdx];
                nextIdx[i] = maxIdx;
                if (max + 1 > maxLen) {
                    maxLen = max + 1;
                    maxIndex = i;
                }
            }
        }
        int curr = maxIndex;
        while (curr >= 0) {
            result.add(nums[curr]);
            curr = nextIdx[curr];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 6, 12, 15, 21, 24, 27};
        System.out.println("Largest subset such that every pair satisfies the give n condition is: " + Arrays.toString(largestDivisibleSubset(nums).toArray()));
    }
}

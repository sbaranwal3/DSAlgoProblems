package challenge.leetcode.days.thirty;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */

public class JumpGame {

    //O(n) time complexity & O(1) space
    public static boolean canJump(int[] nums) {
        if (nums[0] == 0)
            return false;
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            //if nums[i]+i> maxReach, update the maxReach value
            maxReach = Math.max(maxReach, nums[i] + i);
            //When maxReach has become i, it means we can't jump any further so break
            if (maxReach == i)
                break;
        }
        //Finally return true if maxReach is greater than or equal to the last index
        return maxReach >= nums.length - 1;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 0, 0, 4};
        System.out.println("Able to reach the end? " + canJump(nums));
    }
}

package miscellaneous;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
 */

class MinJumpsToReachEnd {
    // Returns Minimum number 
    // of jumps to reach end 
    public static int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j < nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = j + i;
                    if(maxVal==i)
                        break;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }

    public static int jumpAprroach2(int[] nums) {
        int n = nums.length, jumps = 1, next = nums[0], max= nums[0];
        if(n <= 1) return 0;
        int i = 1;
        while(i < n){
            max = Math.max(max, i + nums[i]);
            //reached till next, time to set new next
            if(i == next && i != n - 1){
                next = max;
                if(next == i) return -1;
                jumps++;
            }
            i++;
        }
        return jumps;
    }

    // Driver Code 
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 1, 0, 9};
//        System.out.println("Minimum number of"
//                + " jumps to reach end is " + jump(nums));
        System.out.println("Minimum number of"
                + " jumps to reach end using Approach2 is " + jumpAprroach2(nums));
    }
} 
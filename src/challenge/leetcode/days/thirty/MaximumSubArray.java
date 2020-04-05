package challenge.leetcode.days.thirty;

public class MaximumSubArray {

        public static int maxSubArray(int[] nums) {
            int maxSoFar = nums[0];
            int maxEndingHere =  nums[0];
            for(int i=1; i<nums.length; i++){
                maxEndingHere += nums[i];
                maxEndingHere = Math.max(nums[i], maxEndingHere);
                maxSoFar = Math.max(maxEndingHere,maxSoFar);
//                if(maxEndingHere > maxSoFar){
//                    maxSoFar = maxEndingHere;
//                }
            }
            return maxSoFar;
        }

    public static void main(String[] args) {
            int nums[] = {1};
        System.out.println("Largest sum of contiguous array is "+maxSubArray(nums));

    }
}

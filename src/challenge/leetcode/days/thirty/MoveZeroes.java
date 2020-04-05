package challenge.leetcode.days.thirty;

import java.util.Arrays;

public class MoveZeroes {

//Solution with O(n^2) complexity
        public static void moveZeroes(int[] nums) {
            int swap=0;
            //Keep two pointers, one two check if the element is 0 and the other to check if the next element is not zero,
            //Keep swapping the numbers until all the zeroes are pushed to the right
            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[i]==0 && nums[j]!=0){
                        swap = nums[i];
                        nums[i] = nums[j];
                        nums[j] = swap;
                    }
                }
            }
        }

        //Solution with O(n) complexity
    static void pushZerosToEnd(int nums[])
    {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[count++] = nums[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < nums.length)
            nums[count++] = 0;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,0,0,0,0,0,0,0,0,0,0,3};
        moveZeroes(nums);
       // pushZerosToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
}

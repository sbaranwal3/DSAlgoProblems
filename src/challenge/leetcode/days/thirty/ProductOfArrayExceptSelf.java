package challenge.leetcode.days.thirty;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /*
    Three different solutions: but solution 1 & 2 fail when one of the numbers is 0 in the array and one of them is non-zero
     */

    public static int[] productExceptSelfWithDivision(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            try {
                nums[i] = product / nums[i];
            } catch (ArithmeticException ex) {
                nums[i] = product;
            }
        }
        return nums;
    }

    public static int[] productExceptSelfUsingLog(int[] nums) {

        /*
        Use property of logs for large numbers
        x = a * b * c * d
log(x) = log(a * b * c * d)
log(x) = log(a) + log(b) + log(c) + log(d)
x = antilog(log(a) + log(b) + log(c) + log(d))
         */

        // epsilon value to maintain precision
        double EPS = 1e-9;
        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += Math.log10(nums[i]);

        // output product for each index
        // anti log to find original product value
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int) (EPS + Math.pow(10.00,
                    sum - Math.log10(nums[i])));
        return nums;
    }


    public static int[] productExceptSelfWithoutDivision(int[] nums) {

        int temp = 1;

        /* Allocate memory for the product array */
        int prod[] = new int[nums.length];

        /* Initialize the product array as 1 */
        for (int j = 0; j < nums.length; j++)
            prod[j] = 1;

        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (int i = 0; i < nums.length; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }

        /* Initialize temp to 1 again for product on right side */
        temp = 1;

        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (int i = nums.length - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }

        return prod;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Product of array except self without using division is: " + Arrays.toString(productExceptSelfWithoutDivision(nums)));
        System.out.println("Product of array except self using division is: " + Arrays.toString(productExceptSelfWithDivision(nums)));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Product of array except self using log is: " + Arrays.toString(productExceptSelfUsingLog(nums2)));
    }
}

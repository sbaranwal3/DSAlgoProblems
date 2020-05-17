package challenge.leetcode.may;

/*
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)



Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1


Note:

-30000 <= A[i] <= 30000
1 <= A.length <= 30000
 */

public class MaximumSumCircularSubArray {
    //Use a different version of Kadane's Algorithm
    //If the sum lies within the non-circular Array, use simple Kadane's algorithm.
    // Else max_sum will be total_sum - min_sum of the non-circular array
    public static int maxSubarraySumCircular(int[] A) {
        int maxSoFar = A[0];
        int maxEndingHere = A[0];
        int minSoFar = A[0];
        int minEndingHere = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            minEndingHere = Math.min(A[i], minEndingHere + A[i]);
            minSoFar = Math.min(minEndingHere, minSoFar);
            sum += A[i];
        }
        return maxSoFar > 0 ? Math.max(maxSoFar, sum - minSoFar) : maxSoFar;
    }

    public static void main(String[] args) {
        int[] A = {-2, -3, -1};
        System.out.println("Maximum circular subArray sum for the given array is " + maxSubarraySumCircular(A));
    }
}

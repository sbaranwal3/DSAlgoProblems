package challenge.leetcode.august;

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {
        int[] result=new int[A.length];
        int even=0;
        int odd=A.length-1;
        for(int i: A)
        {
            if(i%2==0)
            {
                result[even]=i;
                even++;
            }
            else
            {
                result[odd]=i;
                odd--;
            }
        }
        return result;
    }

    public static int[] sortArrayByParityBinaryApproach(int[] A)
    {
        int indx=0,val;
        for(int i=0;i<A.length;i++)
        {
            if((A[i]&1)!=1)
            {
                val=A[indx];
                A[indx]=A[i];
                A[i]=val;
                indx++;
            }
        }
        return A;
    }

    /*
    Intuition

If we want to do the sort in-place, we can use quicksort, a standard textbook algorithm.

Algorithm

We'll maintain two pointers i and j. The loop invariant is everything below i has parity 0 (ie. A[k] % 2 == 0 when k < i), and everything above j has parity 1.

Then, there are 4 cases for (A[i] % 2, A[j] % 2):

If it is (0, 1), then everything is correct: i++ and j--.

If it is (1, 0), we swap them so they are correct, then continue.

If it is (0, 0), only the i place is correct, so we i++ and continue.

If it is (1, 1), only the j place is correct, so we j-- and continue.

Throughout all 4 cases, the loop invariant is maintained, and j-i is getting smaller. So eventually we will be done with the array sorted as desired.
     */
    public int[] sortArrayByParityQuickSortApproach(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        System.out.println("Sorted array after parity is: " + Arrays.toString(sortArrayByParity(A)));
        System.out.println("Sorted array after parity using binaryApproach is: " + Arrays.toString(sortArrayByParityBinaryApproach(A)));
    }
}

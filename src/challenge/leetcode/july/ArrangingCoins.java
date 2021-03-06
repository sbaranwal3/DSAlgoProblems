package challenge.leetcode.july;

/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 */

public class ArrangingCoins {

    public static int arrangeCoinsApproach2(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }

    public static int arrangeCoins(int n) {
        long k = (long) Math.sqrt(2 * (long) n);
        long sum = k * (k + 1) / 2;
        if (sum > n)
            return (int) k - 1;
        return (int) k;
    }


    public static void main(String[] args) {
        int n = 8;
        System.out.println("Total number of full stair case coins formed is: " + arrangeCoins(n));
        System.out.println("Total number of full stair case coins formed usingApproach2 is: " + arrangeCoinsApproach2(n));
    }
}

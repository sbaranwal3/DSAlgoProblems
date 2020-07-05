package challenge.leetcode.june;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            int minVal = x;
            int y = 1, sq = 1;
            while (sq <= x) {
                minVal = Math.min(minVal, 1 + dp[x - sq]);
                y++;
                sq = y * y;
            }
            dp[x] = minVal;
        }
        return dp[n];
    }

    public static int numSquaresApproach2(int n) {
        //Three square theorem
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }
    private static boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("No. of perfect squares suming to " + n + " are: " + numSquares(n));
        System.out.println("No. of perfect squares suming to " + n + " using Appraoch2 are: " + numSquaresApproach2(n));
    }
}

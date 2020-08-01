package challenge.leetcode.july;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */

public class ClimbingStairs {
    //DP O(n)
    public static int climbStairs(int n) {
        if (n < 3)
            return n;
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }

    //Fibonacci's formula O(logn)
    //https://leetcode.com/articles/climbing-stairs/
    public static int climbStairsApp2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of ways to climb stairs is: " + climbStairs(n));
        System.out.println("Number of ways to climb stairs is: " + climbStairsApp2(n));
    }
}

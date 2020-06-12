package challenge.leetcode.june;

/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1


Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 */

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] < 0 ? 0 : dp[i][j - coins[i - 1]]);
            }
        }
        return dp[coins.length][amount];
    }

    public static int changeApproach2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int j = c; j <= amount; j++)
                dp[j] += dp[j - c];
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("Total no. of ways to make up " + amount + " with the given coins is: " + change(amount, coins));
        System.out.println("Total no. of ways to make up " + amount + " with the given coins using approach2 is: " + changeApproach2(amount, coins));
    }
}

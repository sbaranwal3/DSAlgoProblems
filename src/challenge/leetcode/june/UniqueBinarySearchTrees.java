package challenge.leetcode.june;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] sol = new int[n + 1];
        sol[0]=1; sol[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++)
                sol[i] += sol[j] * sol[i - j - 1];
        }
        return sol[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of unique binary trees are: " + numTrees(n));
    }
}

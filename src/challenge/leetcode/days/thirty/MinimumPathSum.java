package challenge.leetcode.days.thirty;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

//Time complexity O(mn), space complexity O(1)
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h == 0)
            return 0;
        int w = grid[0].length;
        if (w == 0)
            return 0;

        //Iterate over the grid and add to the current grid value, the minimum of the left or top
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //if both left and right exist, take minimum of the two and add
                if (i > 0 && j > 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                //if one of them exists, just add that value
                else {
                    if (i > 0)
                        grid[i][j] += grid[i - 1][j];
                    if (j > 0)
                        grid[i][j] += grid[i][j - 1];
                }
            }
        }
        //finally, return the lowermost right corner grid
        return grid[h - 1][w - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("The minimum sum is " + minPathSum(grid));
    }
}

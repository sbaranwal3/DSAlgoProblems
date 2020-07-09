package challenge.leetcode.july;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

 */

public class IslandPerimeter {
    //Iterative
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    static int peri;

    //Recursive
    public static int islandPerimeterApproach2(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    dfs(grid, i, j);
            }
        }
        return perimeter;
    }

    static void dfs(int[][] grid, int i, int j) {
        //while doing dfs, mark the adjacent 1's to 0 or any other value by again calling the dfs method
        // so as to assure we are not iterating over it again
        grid[i][j] = 2;
        if (i == 0 || grid[i - 1][j] == 0)
            peri++;
        if (j == 0 || grid[i][j - 1] == 0)
            peri++;
        if (i == grid.length - 1 || grid[i + 1][j] == 0)
            peri++;
        if (j == grid.length - 1 || grid[i][j + 1] == 0)
            peri++;
        if (i > 0 && grid[i - 1][j] == 1)
            dfs(grid, i - 1, j);
        if (j > 0 && grid[i][j - 1] == 1)
            dfs(grid, i, j - 1);
        if (i < grid.length - 1 && grid[i + 1][j] == 1)
            dfs(grid, i + 1, j);
        if (j < grid.length - 1 && grid[i][j + 1] == 1)
            dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        //   System.out.println("Perimeter of the given island is: " + islandPerimeter(grid));
        System.out.println("Perimeter of the given island is: " + islandPerimeterApproach2(grid));
    }
}

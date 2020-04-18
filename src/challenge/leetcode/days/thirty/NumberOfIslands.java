package challenge.leetcode.days.thirty;

/**
 *   Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

public class NumberOfIslands {
    //Using DFS
    public static int numIslands(char[][] grid) {
        int height = grid.length;
        if(height==0)
            return 0;
        int width = grid[0].length;
        if(width==0)
            return 0;

        int count=0;

        //Iterate over the height and then for each height, iterate over the width
        for(int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                //whenever a 1 is encountered, increase the islands count and do a depth first search to see how many adjacent ones exist
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }


    static void dfs(char[][] grid, int x, int y){
        //while doing dfs, mark the adjacent 1's to 0 or any other value by again calling the dfs method
        // so as to assure we are not iterating over it again
        grid[x][y] = '0';

        //Check it's right node
        if(x+1 < grid.length && grid[x+1][y] == '1')
            dfs(grid, x+1, y);
        //Check it's left node
        if(x-1 >=0 && grid[x-1][y] == '1')
            //Check the node below it
            dfs(grid, x-1, y);
        if(y-1 >=0 && grid[x][y-1] == '1')
            //Check the node above it
            dfs(grid, x, y-1);
        if(y+1 < grid[0].length && grid[x][y+1] == '1')
            dfs(grid, x, y+1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println("Number of islands is: "+numIslands(grid));
    }
}

package miscellaneous;
/*
Given a MxN array consisting of 0s, 1s & 2s where 0 denotes no humans, 1 denotes humans with no virus, 2 denotes humans with virus.
 People with virus spread it to their neighbours(up, down, left & right).
 Find the minimum time for the whole grid to be virus affected.
  Note: Virus doesn’t spread through air so grids with 0 remain unaffected
 */

public class VirusSpreadTime {
    public static int minTime(int grid[][]) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        int countOne = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i][j] = grid[i][j];
                if (grid[i][j] == 1)
                    countOne++;
            }
        }
        int t = 0;
        int newCountOne;
        while (!grid.equals(newGrid)) {
            newCountOne = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (i + 1 < grid.length && grid[i + 1][j] != 0)
                            newGrid[i + 1][j] = 2;
                        //Check it's left node
                        if (i - 1 >= 0 && grid[i - 1][j] != 0)
                            newGrid[i - 1][j] = 2;
                        if (j - 1 >= 0 && grid[i][j - 1] != 0)
                            newGrid[i][j - 1] = 2;
                        if (j + 1 < grid[0].length && grid[i][j + 1] != 0)
                            newGrid[i][j + 1] = 2;
                    }
                    if (newGrid[i][j] == 1)
                        newCountOne++;
                }
            }
            if (countOne == newCountOne) {
                return t==0?-1:t;
            }
            t++;
            grid = newGrid;
            countOne = newCountOne;
            newGrid = new int[grid.length][grid[0].length];
        }
        return t == 0 ? -1 : t;
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 1, 1},
                        {1, 0, 1, 1, 0},
                        {1, 0, 0, 0, 2}};
        System.out.println("Time taken for the virus to spread is " + minTime(grid));
    }
}

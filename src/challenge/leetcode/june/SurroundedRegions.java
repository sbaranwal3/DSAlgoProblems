package challenge.leetcode.june;

import java.util.Arrays;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border,
which means that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public static void solve(char[][] board) {
        int m = board.length;
        if (m <= 2) return;
        int n = board[0].length;
        if (n <= 2) return;
        for(int j = 0; j<n; j++){
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }

        for(int i = 0; i<m; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }

        convert(board, 'O', 'X');
        convert(board, 'S', 'O');

    }

    public static void dfs(char[][] board, int i, int j){
        if(i < 0 || i>= board.length || j < 0 || j>=board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'S';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }

    public static void convert(char[][] board, char a, char b){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == a)
                    board[i][j] = b;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        System.out.println("Original board is:");
        ;
        for (char[] b : board)
            System.out.println(Arrays.toString(b));
        solve(board);
        System.out.println("Board after regions are surrounded is:");
        ;
        for (char[] b : board)
            System.out.println(Arrays.toString(b));
    }
}

package miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        return isValidByRow(board, row) && isValidByColumn(board, col) && isValidBySubBoxes(board, row - row % 3, col - col % 3);
    }

    private static boolean isValidByRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (set.contains(board[row][i]))
                return false;
            if (board[row][i] != '.')
                set.add(board[row][i]);
        }
        return true;
    }

    private static boolean isValidByColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (set.contains(board[j][col]))
                return false;
            if (board[j][col] != '.')
                set.add(board[j][col]);
        }
        return true;
    }

    private static boolean isValidBySubBoxes(char[][] board, int startRow, int startCol) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (set.contains(board[row + startRow][col + startCol]))
                    return false;
                if (board[row + startRow][col + startCol] != '.')
                    set.add(board[row + startRow][col + startCol]);
            }
        }
        return true;
    }

    private static boolean isValidSudokuApproach2(char[][] board){
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] cube = new boolean[9][9];

            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {

                    if(board[i][j] == '.')
                        continue;

                    int val = board[i][j] - '1';

                    if(row[i][val] || col[j][val] || cube[3*(i/3) + j/3][val])
                        return false;
                    row[i][val] = col[j][val] = cube[3*(i/3) + j/3][val] = true;
                }
            }

            return true;
    }

    public static boolean isValidSudokuApproach3(char[][] board) {

        int row[] = new int[9];
        int col[] = new int[9];
        int square[] = new int[9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int no = board[i][j];
                    //mark row
                    if((row[i] & (1 << no)) != 0)
                        return false;
                    else
                        row[i] = row[i] | (1 << no);

                    //mark column
                    if((col[j] & (1 << no)) != 0)
                        return false;
                    else
                        col[j] = col[j]  | (1 << no);

                    // mark square
                    int sq = (i/3)*3 + (j/3);
                    if((square[sq] & (1 << no)) != 0)
                        return false;
                    else
                        square[sq] = square[sq]  | (1 << no);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("Is the given sudoku valid? " + isValidSudoku(board));
        System.out.println("Is the given sudoku valid by Approach2? " + isValidSudokuApproach2(board));
        System.out.println("Is the given sudoku valid by Approach3? " + isValidSudokuApproach3(board));
    }
}

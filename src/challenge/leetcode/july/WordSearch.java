package challenge.leetcode.july;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

public class WordSearch {
    private static boolean search(char[][] board, int i, int j, String word, int idx) {
        if(idx == word.length()-1)
            return true;
        board[i][j]-=65;
        if(i>0 && board[i-1][j]==word.charAt(idx+1) && search(board, i-1, j, word, idx+1))
            return true;
        if(j>0 && board[i][j-1]==word.charAt(idx+1) && search(board, i, j-1, word, idx+1))
            return true;
        if(i<board.length-1 && board[i+1][j]==word.charAt(idx+1) && search(board, i+1, j, word, idx+1))
            return true;
        if(j<board[0].length-1 && board[i][j+1]==word.charAt(idx+1) && search(board, i, j+1, word, idx+1))
            return true;
        board[i][j]+=65;
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int r=board.length, c=board[0].length;
        for (int i = 0; i <r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j]==word.charAt(0) && search(board,i,j,word,0))
                    return true;
            }
        }

        return false;
}

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "SEE";
        System.out.println("Does word exist? "+exist(board, word));
    }
}

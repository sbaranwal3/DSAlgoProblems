package challenge.leetcode.days.thirty;

import java.util.Arrays;
import java.util.List;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
public class MaximalSquare {
    //Time complexity O(mn) Space Complexity O(mn)
    public static int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;
        if (c == 0)
            return 0;
        int maxSquareSide = 0;
        int[][] resultMatrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        resultMatrix[i][j] = 1;
                    else
                        resultMatrix[i][j] = 1 + Math.min(Math.min(resultMatrix[i - 1][j], resultMatrix[i][j - 1]), resultMatrix[i - 1][j - 1]);
                    maxSquareSide = Math.max(maxSquareSide, resultMatrix[i][j]);
                }
            }
        }
        int maxSquare = maxSquareSide * maxSquareSide;
        return maxSquare;
    }

    //Time complexity O(mn) Space Complexity O(n)
    public static int maximalSquareApproach2(char[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;
        if (c == 0)
            return 0;
        int maxSquareSide = 0;
        int[] resultMatrix = new int[c];
        int diag = matrix[0][0] == '0' ? 0 : 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = resultMatrix[j];
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        resultMatrix[j] = 1;
                    else
                        resultMatrix[j] = 1 + Math.min(Math.min(resultMatrix[j], resultMatrix[j - 1]), diag);
                    maxSquareSide = Math.max(maxSquareSide, resultMatrix[j]);
                } else
                    resultMatrix[j] = 0;
                diag = j == c - 1 ? resultMatrix[0] : temp;
            }
        }
        int maxSquare = maxSquareSide * maxSquareSide;
        return maxSquare;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println("Area of the largest square containing only 1's is: " + maximalSquare(matrix));
        System.out.println("Area of the largest square containing only 1's using 1d array is: " + maximalSquareApproach2(matrix));
    }
}

package challenge.leetcode.may;

import java.util.Arrays;

/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 */
public class CountSquareSubMatricesWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0)
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                    sum += matrix[i][j];
                }
            }
        }
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
        return sum;
    }

    public static int countSquaresApproach2(int[][] matrix) {
        int r=matrix.length;
        int c= matrix[0].length;
        int[] counts = new int[c];
        int topLeft=0;
        int result=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j]==1){
                    int top=(i==0)?0: counts[j];
                    int left=(j==0)?0:counts[j-1];
                    counts[j]=1 + Math.min(Math.min(top, left), topLeft);
                    result+=counts[j];
                    topLeft = (j==c-1)?0:top;
                }else
                    counts[j]=0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}};
        System.out.println("Number of squares with all ones for the given matrix using Approach2 is: " + countSquaresApproach2(matrix));
        System.out.println("Number of squares with all ones for the given matrix is: " + countSquares(matrix));
    }
}

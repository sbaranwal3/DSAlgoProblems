package challenge.leetcode.august;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++)
            row.add(1);
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--)
                row.set(j, row.get(j) + row.get(j - 1));
        }
        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println("Kth index row of Pascal's triangle is: " + Arrays.toString(getRow(rowIndex).toArray()));
    }
}

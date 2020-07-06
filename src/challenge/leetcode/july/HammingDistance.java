package challenge.leetcode.july;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while (result > 0) {
            count += result & 1;
            result >>= 1;
        }
        return count;
    }

    public static int hammingDistanceInBuilt(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println("Hamming distance between " + x + " & " + y + " is: " + hammingDistance(x, y));
        System.out.println("Hamming distance between " + x + " & " + y + " using InBuilt function is: " + hammingDistanceInBuilt(x, y));
    }
}

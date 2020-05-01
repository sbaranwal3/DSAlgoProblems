package challenge.leetcode.days.thirty;

/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */

//Bitwise properties for a given power of 2 is same for MSB and then the 2nd MSB
// is half 0 & half1 and then the 3rd MSB is 1/4th 0, 1/4th 1, 1/4th 0 & 1/4th 1 and so on
//No. of bits for a given integer is
public class BitwiseANDOfNumbersRange {

    //Time O(n) & Space O(1)
    public static int rangeBitwiseAnd(int m, int n) {
        int range = m;
        for (int i = m + 1; i <= n; i++)
            range = range & i;

        return range;
    }

    //Time O(log(n)) & Space O(1)
    public static int rangeBitwiseAndUsingMSB(int m, int n) {
        int shifts = 0;
        int bitsInM = (int) (Math.log(m) /
                Math.log(2) + 1);
        int bitsInN = (int) (Math.log(n) /
                Math.log(2) + 1);
        if (bitsInM != bitsInN)
            return 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shifts++;
        }
        return n << shifts;
    }

    public static void main(String[] args) {
        int m = 3, n = 7;

        //    System.out.println("Bitwise AND Of Numbers in the range is: "+ rangeBitwiseAnd(m,n));
        System.out.println("Bitwise AND Of Numbers in the range is: " + rangeBitwiseAndUsingMSB(m, n));
    }
}

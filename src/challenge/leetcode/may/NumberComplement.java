package challenge.leetcode.may;

/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.



Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.


Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


Note:

The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberComplement {
    //Theory used: XOR of any bit with 1 gives it's complement
   // 0^1 = 0
    // 1^1 = 1
    //Step 1: Get the bits count of the number
    //Step 2: Get the mask number with bit representation as all 1s with the same no. of bits
    //Step 3: Get XOR of the mask with the actual number
    public static int findComplement(int num) {
        if(num==0)
            return 1;
        //Find number of bits first using log function
        int numBits = (int) (Math.log(num) /
                Math.log(2) + 1);
        //Calculate the mask value for which XOR is supposed to be taken which is Math.pow(2, numBits) - 1
        //or (1<< numBits) - 1
        int mask = (int) Math.abs(Math.pow(2, numBits)-1);
        //int mask = Math.abs(1<< numBits)-1;
        return num^mask;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("The complement of 5 is: " + findComplement(num));
    }
}

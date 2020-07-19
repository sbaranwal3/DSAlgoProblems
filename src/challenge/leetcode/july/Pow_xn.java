package challenge.leetcode.july;

/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

public class Pow_xn {

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0 || x == 1)
            return x;
        double result = myPow(x, n / 2);
        if (n % 2 == 0)
            return result * result;
        else {
            if (n > 0)
                return x * result * result;
            else
                return result * result / x;
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println("Power of " + x + "," + n + " is: " + myPow(x, n));
    }
}

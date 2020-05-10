package challenge.leetcode.may;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */
public class ValidPerfectSquare {

    //Time O(n) & Space O(1)
    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1)
            return true;
        if (num == Integer.MAX_VALUE)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if ((num % i == 0) && (num / i == i)) {
                return true;
            }
        }
        return false;
    }

    //Time O(log(n)) & Space O(1)
    public static boolean isPerfectSquareUsingBinarySearch(int num) {
        if (num == 0 || num == 1)
            return true;
        int unit = num % 10;
        if (unit == 2 || unit == 3 || unit == 7 || unit == 8)
            return false;
        int l = 2;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (num % mid == 0 && num / mid == mid)
                return true;
            else if (num / mid > mid)
                l = mid + 1;
            else
                r = mid - 1;

        }
        return false;
    }

//    //Time O(10) max & Space O(1)!!! Note: This logic doesn't work always
//    public static boolean isPerfectSquareUsingMathsLogic(int num) {
//        int unit = num % 10;
//        if (unit == 2 || unit == 3 || unit == 7 || unit == 8)
//            return false;
//        int digitSum = digitSum(num);
//        while(digitSum/10 != 0) {
//            digitSum = digitSum(digitSum);
//        }
//        if (digitSum == 1 || digitSum == 4 || digitSum == 7 || digitSum == 9)
//            return true;
//
//        return false;
//    }
//
//    public static int digitSum(int num) {
//        int n, digitSum = 0;
//        while (num > 0) {
//            n = num % 10;
//            digitSum = digitSum + n;
//            num = num / 10;
//        }
//        return digitSum;
//    }


    public static void main(String[] args) {
        int num = 855;
        System.out.println("Is " + num + " a valid perfect square? " + isPerfectSquare(num));
        System.out.println("Is " + num + " a valid perfect square using Binary Search? " + isPerfectSquareUsingBinarySearch(num));
//        System.out.println("Is " + num + " a valid perfect square using simple Maths logic " + isPerfectSquareUsingMathsLogic(num));
    }
}

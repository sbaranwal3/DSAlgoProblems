package miscellaneous;

/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

import java.util.Stack;

public class RemoveKDigits {

    //Greedy Algorithm: Time Complexity O(kn), Space O(1)
    public static String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";
        if (k == 0)
            return num;

        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i < num.length()) {
                while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                    sb.deleteCharAt(sb.length() - 1);
                    k--;
                }
            sb.append(num.charAt(i));
            i++;
        }
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.substring(0, sb.length() - k);

    }

    public static String removeKdigitsUsingStack(String num, int k) {
        if (k >= num.length())
            return "0";
        if (k == 0)
            return num;

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char curChar = stack.pop();
            sb.append(curChar);
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "19864409232";
        int k = 5;
        System.out.println("Smallest number after removing " + k + " digits is: " + removeKdigits(num, k));
        System.out.println("Smallest number after removing " + k + " digits using stack is: " + removeKdigitsUsingStack(num, k));
    }
}

package challenge.leetcode.june;

/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */

public class ReverseString {
    //forLoop runtime: 1ms
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    //whileLoop runtime: 0ms
    public static void reverseStringApproach2(char[] s) {
        int left =0, right = s.length-1;
        while (left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s1 = "mahbuhs".toCharArray();
        System.out.println("Reverse of the given string is: ");
        reverseString(s1);
        System.out.println(s1);
        char[] s2 = "akihsar".toCharArray();
        System.out.println("Reverse of the given string is: ");
        reverseStringApproach2(s2);
        System.out.println(s2);
    }
}

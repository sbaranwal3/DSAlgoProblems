package challenge.leetcode.days.thirty;

import java.util.Stack;

public class BackspaceStringCompare {

    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     *
     * Example 1:
     *
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     *
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     *
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     *
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     * Note:
     *
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     * Follow up:
     *
     * Can you solve it in O(N) time and O(1) space?
     */

    public static boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        return typed(S).equals(typed(T));
    }

    private static String typed(String t) {
        //Initialize a stack with space O(1) and remove the previous character(pop) if current character is '#'
        //Else add it(push)
        Stack<Character> tempStack = new Stack<>();
        for(char i: t.toCharArray()){
            if(i=='#') {
                if (!tempStack.isEmpty()) {
                    tempStack.pop();
                }
            }
                else{
                    tempStack.push(i);
                }
        }

        //Below code not needed if printing is not required, we can just return tempStack.toString
        StringBuffer sb = new StringBuffer();
        while (!tempStack.isEmpty()) {
            sb.append(tempStack.pop());
        }
        return sb.toString();
      //  return tempStack.toString();

    }

    public static void main(String[] args) {
        String S = "#######c######defegr";
        String T = "#######l######defegr";

        System.out.println("Are strings same: "+ backspaceCompare(S, T));
    }
}

package challenge.leetcode.july;

/*
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.


Follow up:

For C programmers, try to solve it in-place in O(1) extra space.
 */

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String result = new String();
        int i=0;
        int n=s.length();
        while(i<n) {
            while (i < n && s.charAt(i) == ' ')
                i++;
            if (i >= n)
                break;
            int j = i + 1;
            while (j < n && s.charAt(j) != ' ')
                j++;
            String sub = s.substring(i, j);
            if (result.length() == 0)
                result = sub;
            else result = sub + " " + result;
            i = j + 1;
        }
        return result;
    }

    public static String reverseWordsApp2(String s) {
        if(s==null)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1, j; i>=0; i--){
            if(s.charAt(i)!=' '){
                j=i;
                i=s.lastIndexOf(' ',i);
                sb.append(s,i+1,j+1).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = " hello world!  ";
        System.out.println("Sentence after reversing words is: " + reverseWords(s));
    }
}

package miscellaneous;

import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    static List<String> result = new ArrayList<>();
    static Map<Character, String> numMap = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;

        mapInit(numMap);
        backtrack(digits, 0, new StringBuilder());
        return result;

    }

    private static void backtrack(String digits, int idx, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        Character ch = digits.charAt(idx);
        String candidate = numMap.get(ch);
        for (int i = 0; i < candidate.length(); i++) {
            sb.append(candidate.charAt(i));
            backtrack(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void mapInit(Map<Character, String> map) {
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println("All the letter combinations for digits:" + digits + " are: " + Arrays.toString(letterCombinations(digits).toArray()));
    }
}

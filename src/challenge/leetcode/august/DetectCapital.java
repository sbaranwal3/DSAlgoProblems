package challenge.leetcode.august;

/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.


Example 1:

Input: "USA"
Output: True


Example 2:

Input: "FlaG"
Output: False


Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        if (word.length() < 2)
            return true;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "flag";
        System.out.println("Is the use of capitals in the given word valid? " + detectCapitalUse(word));
    }
}

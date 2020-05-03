package challenge.leetcode.may;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    //O(JS) time complexity & O(1) space if toCharArray space is ignored
    public static int numJewelsInStonesApproach1(String J, String S) {
        if (J.length() == 0 || S.length() == 0)
            return 0;
        int jewelsCount = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    jewelsCount++;
                }
            }
        }
        return jewelsCount;
    }

    //O(S) time complexity & O(max(J,S)) space complexity
    public static int numJewelsInStonesApproach2(String J, String S) {
        if (J.length() == 0 || S.length() == 0)
            return 0;
        Set<Character> jewels = new HashSet<>();
        int jewelsCount = 0;
        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));
            for (int j = 0; j < S.length(); j++) {
                if (jewels.contains(S.charAt(j))) {
                    jewelsCount++;
                }
            }

        return jewelsCount;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println("Number of stones that are jewels are: " + numJewelsInStonesApproach1(J, S));
        System.out.println("Number of stones that are jewels using HashSet are: " + numJewelsInStonesApproach2(J, S));
    }
}

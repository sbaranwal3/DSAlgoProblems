package challenge.leetcode.august;

/*
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.


Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false


Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
   Hide Hint #1
Generate all combinations as a preprocessing.
   Hide Hint #2
Use bit masking to generate all the combinations.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
    String s;
    Queue<String> q;

    private void getCombination(int start, int length, StringBuilder txt) {
        if (length == 0) {
            q.add(txt.toString());
            return;
        }

        for (int i = start; i <= s.length() - length; i++) {
            txt.append(s.charAt(i));
            getCombination(i + 1, length - 1, txt);
            txt.deleteCharAt(txt.length() - 1);
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        q = new LinkedList<>();
        getCombination(0, combinationLength, new StringBuilder());
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }

}

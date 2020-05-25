package challenge.leetcode.may;

/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        Comparator<Character> valueComparator = (e1, e2) -> {
            Integer v1 = map.get(e1);
            Integer v2 = map.get(e2);
            return v2.compareTo(v1);
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Character> listOfEntries = new ArrayList<>(map.keySet());
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        StringBuilder sb = new StringBuilder();
        for (Character c : listOfEntries) {
            for (int i = 0; i < map.get(c); i++)
                sb.append(c);
        }
        return sb.toString();
    }

    public static String frequencySortUsingPriorityQueue(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<Character> queue = new PriorityQueue<>((e1, e2) -> map.get(e2) - map.get(e1));
        queue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.remove();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "shubham";
        System.out.println("Result string after sorting chars by frequency is: " + frequencySort(s));
        System.out.println("Result string after sorting chars by frequency using queue is: " + frequencySortUsingPriorityQueue(s));
    }
}

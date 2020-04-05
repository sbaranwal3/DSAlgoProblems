import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.lang.System;

class NumTilePossibiities {

    public static void main(String[] args) {
        String a = "AAABBC";
        System.out.println(numTilePossibilities(a));
    }
    private static int result = 0;

    public static int numTilePossibilities(String tiles) {
        char[] elements = tiles.toCharArray();
        Arrays.sort(elements);
        boolean[] boolMarked = new boolean[tiles.length()];
        getPermutations(elements,  boolMarked);
        return result;
    }

    private static void getPermutations(char[] elements, boolean[] marked) {
        char letter = '\0';
        for (int i = 0; i < elements.length; i++) {
            if (letter == elements[i] || marked[i]) continue;
            letter = elements[i];
            marked[i] = true;
            result++;
            getPermutations(elements, marked);
            marked[i] = false;
        }
    }
}
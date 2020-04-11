package challenge.leetcode.days.thirty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingElements {

    /*
    Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.


Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
     */


    public static int countElements(int[] arr) {
        //Create a hashMap to maintain the key as unique numbers and value as their count
        Map<Integer, Integer> tempMap = new HashMap<>();
        int count = 0;
        //Iterate over the array and populate the map
        for (int i = 0; i < arr.length; i++) {
            if (tempMap.containsKey(arr[i])) {
                tempMap.put(arr[i], tempMap.get(arr[i]) + 1);
            } else {
                tempMap.put(arr[i], 1);
            }
        }
        //Iterate over the map and check if there's an element existing with a value of key+1, if yes, increment count as the the occurence of the key
        for (Integer j : tempMap.keySet()) {
            if (tempMap.containsKey(j + 1)) {
                count += tempMap.get(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 3, 5, 3, 3};
        System.out.println("No. of such elements are " + countElements(array));
    }
}

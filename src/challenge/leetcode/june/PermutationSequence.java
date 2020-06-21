package challenge.leetcode.june;

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
            int[] factorials = new int[n];
            List<Integer> list = new ArrayList();
            list.add(1);

            factorials[0] = 1;
            for(int i = 1; i < n; ++i){
                // generate factorials  0!, 1!, ..., (n - 1)!
                factorials[i] = factorials[i - 1] * i;
                // generate nums 1, 2, ..., n
                list.add(i + 1);
            }

            // Decrementing k
            k--;

            // compute factorial representation of k
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i >= 0; i--){
                int j = k / factorials[i];
                k -= j * factorials[i];

                sb.append(list.get(j));
                list.remove(j);
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        int n=3, k=3;
        System.out.println("Permutation Sequence is: "+getPermutation(n,k));

    }
}

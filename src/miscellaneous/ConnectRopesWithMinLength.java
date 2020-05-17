package miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of integers A representing the length of ropes.
You need to connect these ropes into one rope.
The cost of connecting two ropes is equal to the product of their lengths.
You need to connect the ropes with minimum cost.

Find and return the minimum cost to connect these ropes into one rope.



Input Format

The only argument given is the integer array A.
Output Format

Return the minimum cost to connect these ropes into one rope.
Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^3
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    148
Explanation 1:
    1 * 2 = 2
    2 * 3 = 6
    4 * 5 = 20
    6 * 20 = 120

    2 + 6 + 20 + 120 = 148

Input 2:
    A = [5, 17, 100, 11]
Output 2:
    94490
Explanation 2:
    5 * 11 = 55
    17 * 55 = 935
    935 * 100 = 93500

    55+935+93500 = 94490
 */
public class ConnectRopesWithMinLength {
    private static int minCost(int[] ropes){
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding items to the pQueue
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue
        // is more than 1
        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result
            // and insert the new rope to pq
            res += first * second;
            pq.offer(first * second);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ropesLen = {1,2,3,4,5};
        System.out.println("Minimum cost of joining all the ropes is "+minCost(ropesLen));
    }
}

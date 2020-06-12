package challenge.leetcode.june;

/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where
 h is the height of the person and k is the number of people in front of this person who have a height greater
 than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.*;

public class QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        //Sort the array in descending order of height of people and if height is same, people with more people in front should be at the back
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        //Now, iterate over the people array and add them in the result list at the position where they have those many people in front of them
        for (int[] person : people)
            result.add(person[1], person);
        return result.toArray(new int[people.length][2]);
    }

    public static int[][] reconstructQueueUsingQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        //Put the elements in priority queue in descending order of height of people
        // and if height is same, people with more people in front should be at the back
        Queue<int[]> heap = new PriorityQueue<>(people.length, (a, b) -> {
            int result = Integer.compare(b[0], a[0]);
            return result == 0 ? Integer.compare(a[1], b[1]) : result;
        });
        for (int[] person : people) {
            heap.offer(person);
        }
        List<int[]> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            result.add(curr[1], curr);
        }
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println("People after reconstruction are: ");
        for (int[] person : reconstructQueue(people))
            System.out.println(Arrays.toString(person));

        System.out.println("People after reconstruction using queue are: ");
        for (int[] person : reconstructQueueUsingQueue(people))
            System.out.println(Arrays.toString(person));
    }
}

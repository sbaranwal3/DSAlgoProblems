package challenge.leetcode.july;

/*
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A


Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */

import java.util.*;

public class TaskScheduler {
    public static int leastIntervalApp2(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        Map<Character, Integer> taskCount = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskCount.put(tasks[i], taskCount.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(taskCount.size(), Collections.reverseOrder());
        queue.addAll(taskCount.values());
        int result = 0;
        while (!queue.isEmpty()) {
            int time = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!queue.isEmpty()) {
                    tmp.add(queue.remove() - 1);
                    time++;
                }
            }
            for (int t : tmp)
                if (t > 0) queue.add(t);
            result += queue.isEmpty() ? time : n + 1;
        }
        return result;
    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        //find max frequency
        int maxF = 0;
        for (int i = 0; i < 26; i++) {
            maxF = Math.max(maxF, freq[i]);
        }
        //find number of tasks with max frequency
        int nMax = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxF)
                nMax++;
        }
        return (Math.max(tasks.length, (maxF - 1) * (n + 1) + nMax));
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Least number of units of times with the given interval is: " + leastInterval(tasks, 2));
    }
}

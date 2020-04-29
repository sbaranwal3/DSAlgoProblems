package challenge.leetcode.days.thirty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueUsingQueue {
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    public FirstUniqueUsingQueue(int[] nums) {
        for (int x : nums)
            add(x);
    }

    //O(n) time complexity
    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1)
            queue.poll();
        return queue.isEmpty() ? -1 : queue.peek();
    }
    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        queue.offer(value);
    }

    public static void main(String[] args) {
        int[] nums={2,3,5};
        FirstUniqueUsingQueue firstUnique = new FirstUniqueUsingQueue(nums);
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique());
    }
}

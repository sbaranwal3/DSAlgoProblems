package challenge.leetcode.days.thirty;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueUsingLinkedHashMap {
    LinkedHashMap<Integer, Integer> count = new LinkedHashMap<>();
    public FirstUniqueUsingLinkedHashMap(int[] nums) {
        for(int num: nums)
            add(num);
    }

    //O(n) time complexity
    public int showFirstUnique() {
        for(Map.Entry<Integer, Integer>entry:count.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }

    public void add(int value) {
        count.put(value, count.getOrDefault(value, 0)+1);
    }

    public static void main(String[] args) {
        int[] nums={2,3,5};
        FirstUniqueUsingLinkedHashMap firstUnique = new FirstUniqueUsingLinkedHashMap(nums);
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique());
    }
}

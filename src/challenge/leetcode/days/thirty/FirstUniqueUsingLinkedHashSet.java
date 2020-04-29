package challenge.leetcode.days.thirty;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueUsingLinkedHashSet {
    Set<Integer> set;
    Set<Integer> all;

    public FirstUniqueUsingLinkedHashSet(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        for (int n : nums)
            add(n);
    }

    //O(1) time complexity
    public int showFirstUnique() {
        if (set.size() == 0)
            return -1;
        return set.iterator().next();
    }

    //O(1) time complexity
    public void add(int value) {
        if (!all.contains(value)) {
            all.add(value);
            set.add(value);
        } else {
            if (set.contains(value))
                set.remove(value);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        FirstUniqueUsingLinkedHashSet firstUnique = new FirstUniqueUsingLinkedHashSet(nums);
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique());
    }
}

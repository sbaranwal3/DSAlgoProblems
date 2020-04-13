package challenge.leetcode.days.thirty;

/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {

    /*
    O( n^2 log(n) ) because for every stone n, we sort the array O(nlog(n))
O(1) space, no extra space, sort in place
     */
    public static int lastStoneWeightUsingArray(int[] stones) {
    Arrays.sort(stones);
    for(int i=stones.length-1; i>0; i--) {
        stones[i-1] = stones[i] - stones[i-1];
        Arrays.sort(stones);
    }
    return stones[0];
    }

    //O(n log (n)) time O(n) space
    public static int lastStoneWeightUsingPriorityQueue(int[] stones) {
        if(stones==null)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            pq.offer(stone);

        int x, y;
        while(pq.size() > 1) {
            y = pq.poll();
            x = pq.poll();
            if(y > x) {
                pq.offer(y-x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println("Last stone left after Using priorityQueue has weight: "+lastStoneWeightUsingPriorityQueue(stones));
        System.out.println("Last stone left after using Array has weight: "+lastStoneWeightUsingArray(stones));
    }
}

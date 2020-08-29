package challenge.leetcode.august;

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //sort the array by end value
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) res++;
            else end = intervals[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Minimum number of intervals needed to remove to make the " +
                "rest of the intervals non-overlapping is: " + eraseOverlapIntervals(intervals));
    }
}

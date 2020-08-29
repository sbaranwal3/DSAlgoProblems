package challenge.leetcode.august;

/*
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.


Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.


Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.


Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            int j = 0;
            int diff = 100000;
            boolean flag = false;
            int idx = -1;
            while (j < intervals.length) {
                if(i == j) {
                    j++;
                    continue;
                }
                int tmp = intervals[j][0] - intervals[i][1];
                if(tmp < diff && tmp > 0) {
                    diff = tmp;
                    flag = true;
                    idx = j;
                } else if (tmp == 0) {
                    flag = true;
                    idx = j;
                    break;
                }
                j++;
            }
            if(!flag) {
                result[i] = -1;
            } else {
                result[i] = idx;
            }
        }
        return result;
    }

    public static int[] findRightIntervalUsingTreeMap(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];

        for(int i  = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }

        for(int i  =0; i < intervals.length; i++){
            Map.Entry<Integer, Integer> pos = map.ceilingEntry(intervals[i][1]);
            res[i] = (pos == null) ? -1 : pos.getValue();
        }
        return res;
    }

    public static int[] findRightIntervalUsingArrays(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < intervals.length; i++) {
            bucket[intervals[i][0] - min] = i;
        }
        for (int i = bucket.length - 2; i >= 0; i--) {
            if(bucket[i] == - 1) bucket[i] = bucket[i + 1];
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = bucket[intervals[i][1] - min];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

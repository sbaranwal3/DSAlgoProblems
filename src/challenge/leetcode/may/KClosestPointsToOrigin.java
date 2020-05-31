package challenge.leetcode.may;

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    //Time complexity(O(N*logN))
    public static int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> (e[1] * e[1] + e[0] * e[0])));
        for (int i = 0; i < points.length; i++)
            queue.add(points[i]);

        int[][] kClosest = new int[K][2];
        for (int j = 0; j < K && !queue.isEmpty(); j++)
            kClosest[j] = queue.poll();

        return kClosest;
    }

    //Time complexity(O(N*logK))
    public static int[][] kClosestApproach2(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K)
                maxHeap.poll();
        }
        int[][] kClosest = new int[K][2];
        int i = 0;
        while (!maxHeap.isEmpty())
            kClosest[i++] = maxHeap.poll();

        return kClosest;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;

        //Approach1
        int[][] kClosest = kClosest(points, K);
        System.out.println("Closest " + K + " points to origin are: ");
        for (int[] point : kClosest)
            System.out.println(Arrays.toString(point));

        //Approach2
        int[][] kClosestApproach2 = kClosestApproach2(points, K);
        System.out.println("Closest " + K + " points to origin using Approach2 are: ");
        for (int[] point : kClosestApproach2)
            System.out.println(Arrays.toString(point));
    }
}

package challenge.leetcode.august;

/*
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformly picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates.
A point on the perimeter of a rectangle is included in the space covered by the rectangles.
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input:
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output:
[null,[4,1],[4,1],[3,3]]
Example 2:

Input:
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output:
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments.
 Arguments are always wrapped with a list, even if there aren't any.
 */

import java.util.Arrays;
import java.util.Random;

public class RandomPointInNonOverlappingRectangles {

    private static int[] sums;
    private static int[][] rects;
    private static Random rand = new Random();

    // for rects = [[1, 1, 2, 4], [3, 2, 5, 4], [2, 5, 5, 6]]
    // sum is [8, 17, 25]

    public RandomPointInNonOverlappingRectangles(int[][] rects)
    {
        this.rects = rects;
        sums = new int[rects.length];
        int sum = 0;
        for (int i = 0; i < rects.length; i++)
        {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sums[i] = sum;
        }
    }

    public int[] pick()
    {
        int lo = 0, hi = sums.length - 1;
        int target = rand.nextInt(sums[sums.length - 1]);

        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (target < sums[mid]) hi = mid;
            else lo = mid + 1;
        }

        int[] rect = rects[lo];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = sums[lo] - width * height;
        return new int[]{rect[0] + (target - base) % width, rect[1] + (target - base) / width};
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
        RandomPointInNonOverlappingRectangles obj = new RandomPointInNonOverlappingRectangles(rects);
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }
}

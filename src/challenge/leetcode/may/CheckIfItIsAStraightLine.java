package challenge.leetcode.may;

/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false


Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */

public class CheckIfItIsAStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3)
            return true;

        //Handling infinity slope when x is constant
        if (coordinates[1][0] == coordinates[0][0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0])
                    return false;
            }
        }
        int m = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        int c = coordinates[1][1] - m * coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (c + m * coordinates[i][0] - coordinates[i][1] != 0)
                return false;
        }
        return true;
    }

    public static boolean checkStraightLineApproach2(int[][] coordinates) {
        if (coordinates.length < 3)
            return true;
        float slope = getSlope(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            float m = getSlope(coordinates[i], coordinates[0]);
            if (m != slope)
                return false;
        }
        return true;
    }

    public static float getSlope(int[] p1, int[] p2) {
        if (p1[0] == p2[0])
            return 1000000;
        return (float) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println("Do the coordinates fall on a straight line? " + checkStraightLine(coordinates));
        System.out.println("Do the coordinates fall on a straight line using Approach2? " + checkStraightLineApproach2(coordinates));
    }
}

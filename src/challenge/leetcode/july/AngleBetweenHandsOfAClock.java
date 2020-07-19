package challenge.leetcode.july;

/*
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.



Example 1:



Input: hour = 12, minutes = 30
Output: 165
Example 2:



Input: hour = 3, minutes = 30
Output: 75
Example 3:



Input: hour = 3, minutes = 15
Output: 7.5
Example 4:

Input: hour = 4, minutes = 50
Output: 155
Example 5:

Input: hour = 12, minutes = 0
Output: 0


Constraints:

1 <= hour <= 12
0 <= minutes <= 59
Answers within 10^-5 of the actual value will be accepted as correct.
   Hide Hint #1
The tricky part is determining how the minute hand affects the position of the hour hand.
   Hide Hint #2
Calculate the angles separately then find the difference.
 */

public class AngleBetweenHandsOfAClock {
    public static double angleClock(int hour, int minutes) {
        float h = (hour % 12 + (float) minutes / 60) * 30;
        float m = minutes * 6;
        float angle = Math.abs(h - m);
        return angle > 180 ? 360 - angle : angle;
    }

    public static void main(String[] args) {
        int hour = 9;
        int minutes = 9;
        System.out.println("Angle between hour and minute hand is: " + angleClock(hour, minutes));
    }
}

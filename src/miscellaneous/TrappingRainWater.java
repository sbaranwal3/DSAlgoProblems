package miscellaneous;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class TrappingRainWater {

    //Time complexity O(n) and space complexity O(n)
    public static int trap(int[] height) {
        if(height==null || height.length<3)
            return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int waterTrapped = 0;
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        for (int j = height.length - 2; j >= 0; j--)
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);


        for (int i = 0; i < height.length; i++)
            waterTrapped += Math.abs(Math.min(leftMax[i], rightMax[i]) - height[i]);

        return waterTrapped;
    }

    //Time complexity O(n) and space complexity O(1)
    public static int trapApproach2(int height[])
    {
        if(height==null || height.length<3)
            return 0;
        // initialize output
        int result = 0;

        // maximum element on left and right
        int leftMax = 0, rightMax = 0;

        // indices to traverse the array
        int low = 0, high = height.length - 1;

        while (low <= high) {
            if (height[low] < height[high]) {
                if (height[low] > leftMax)

                    // update max in left
                    leftMax = height[low];
                else

                    // water on curr element =max - curr
                    result += leftMax - height[low];
                low++;
            }
            else {
                if (height[high] > rightMax)

                    // update right maximum
                    rightMax = height[high];

                else
                    result += rightMax - height[high];
                high--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Amount of water trapped is: " + trap(height));
        System.out.println("Amount of water trapped using approach 2 is: " + trapApproach2(height));
    }
}

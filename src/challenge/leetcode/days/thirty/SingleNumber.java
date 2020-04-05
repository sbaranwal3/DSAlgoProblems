package challenge.leetcode.days.thirty;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        //Solved using XOR concept
        //XOR of no. with itself is 0 and XOR of no. with 0 is the same number
        //So if all elements repeat twice, except one, XOR will be eg: 4^1^2^1^2 = 4^(1^1)^(2^2) = //4^0^0 = 4^0 = 4 which is the answer

        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main (String[] args)
    {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        System.out.println("Element occurring once is " +
                singleNumber(ar) + " ");
    }
}

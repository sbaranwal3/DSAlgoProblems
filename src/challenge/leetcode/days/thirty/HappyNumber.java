package challenge.leetcode.days.thirty;

import java.util.ArrayList;
import java.util.List;

class HappyNumber {
    public static boolean isHappy(int n) {
        //Create a new sum variable
        int sum = 0;
        //Create a new sums list just to keep track of all the sums
        List<Integer> sums = new ArrayList<>();
        //Traverse till the sum becomes 1
        while(sum!=1){
            //Initialize reminder as 0. Also reset sum to 0 for every new sum calculation
            int rem = 0;
            sum=0;
            //FInd the sum of the square of the digits till the sum becomes 0;
            while (n != 0) {
               // eg: if no. is 19,
                // rem = 19%10 == 9
                //sum = 0+9^2=81
                //n = 19/10 = 1
                //Again, rem = 1%10 = 1
                //sum = 81+1^2 = 82
                //n = 1/10 = 0
                rem = n % 10;
                sum = sum + (rem * rem);
                n = n / 10;
            }
            if(sums.contains(sum)&& sum!=1){
                return false;
            }
                sums.add(sum);
                n=sum;
        }
        return true;
    }

    public static void main (String[] args)
    {
        int n =478;
        System.out.println("Is Happy Number? " +isHappy(n));
    }
}

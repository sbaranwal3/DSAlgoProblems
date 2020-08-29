package challenge.leetcode.august;

/*
Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call any other API. Please don't use the system's Math.random().

Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be called while testing.

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?


Example 1:

Input: n = 1
Output: [2]
Example 2:

Input: n = 2
Output: [2,8]
Example 3:

Input: n = 3
Output: [3,8,10]


Constraints:

1 <= n <= 105
 */

public class ImplementRand7UsingRand10 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    public int rand7(){
        return 0;
    };
  //  class Solution extends SolBase {
        public int rand10() {
            int v1 = rand7(), v2=rand7();
            while(v1>5) v1 = rand7();
            while(v2 == 7) v2 = rand7();
            return (v2<=3)? v1: v1+5;
        }

    int ct = 1;
    int next = 7;

    public int rand10App2() {
        if (ct >= 8 && ct <= 10) {
            ct++;
            next++;
            return next;
        } else if (ct > 10) {
            ct = 2;
            next = 7;
            return rand7();
        }

        ct++;
        return rand7();
    }
 //   }
}

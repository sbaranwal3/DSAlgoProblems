import java.lang.reflect.Array;

public class FibonacciSequence {

    public static void main(String[] args) {
        int n= 2000;
//        long startTime = System.currentTimeMillis();
//        System.out.println(getFibonacciNumber(n));
//        long elapsedTime = System.currentTimeMillis() - startTime;
//        System.out.println("Execution took (in millis): " + elapsedTime);

        Integer memo[] = new Integer[n+1];
        long startTime1 = System.currentTimeMillis();
        System.out.println(getFibonacciNumberThroughMemoization(n, memo));
        long elapsedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("Execution for memoization took (in millis): " + elapsedTime1);

//        long startTime2 = System.currentTimeMillis();
//        System.out.println(getFibonacciNumberThroughBottomUp(n));
//        long elapsedTime2 = System.currentTimeMillis() - startTime2;
//        System.out.println("Execution for bottom up took (in millis): " + elapsedTime2);

    }

    private static int getFibonacciNumber(int n) {
        int result;
        if (n==1 || n==2){
            result = 1;
        }
        else{
            result = getFibonacciNumber(n-1)+getFibonacciNumber(n-2);
        }
        return  result;
    }

    private static int getFibonacciNumberThroughMemoization(int n, Integer memo[]) {
        int result;
        if (null != memo[n]){
            return memo[n];
        }
        if (n==1 || n==2){
            result = 1;
        }
        else{
            result = getFibonacciNumberThroughMemoization(n-1, memo)+getFibonacciNumberThroughMemoization(n-2, memo);
            memo[n] = result;
        }
        return  result;
    }

    private static int getFibonacciNumberThroughBottomUp(int n) {
        if (n==1 || n==2){
            return 1;
        }
int bottom_up[] = new int[n+1];
        bottom_up[0]=1;
        bottom_up[1]=1;
        for(int i=2; i<n+1; i++){
            bottom_up[i] = bottom_up[i-1]+bottom_up[i-2];
        }
        return  bottom_up[n];
    }

}


//1,1,2,3,5
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

 class Solution {
     public static int divide(int dividend, int divisor) {
         int i = 0;
         if (dividend > 0) {
             if (divisor > 0) {
                 while (dividend >= divisor) {
                     dividend = dividend - divisor;
                     i++;
                 }
                 return i;
             } else if (divisor < 0) {
                 divisor*= -1;
                 while (dividend >= divisor) {
                     dividend = dividend - divisor;
                     i++;
                 }
                 return -i;

             }

         } else if (dividend < 0 && divisor<0) {
             if(dividend <= -2147483647){
                 dividend = -2147483647;
             }
             dividend = -dividend;
             divisor = -divisor;
             while (dividend >= divisor) {
                 dividend = dividend - divisor;
                 i++;
             }
             if(dividend <-2147483647 && i==-2147483647){
                 return -2147483648;
             }
             return i;
         } else if (dividend < 0 && divisor>0) {
             if(dividend <= -2147483647){
                 int diviD = 0;
                 diviD = -2147483647;
                 diviD= -diviD;
                 while (diviD >= divisor) {
                     diviD = diviD - divisor;
                     i++;
                 }
                 if(dividend <-2147483647 && i==2147483647){
                     return -2147483648;
                 }
                 return -i;
             }else{
                 dividend =-dividend;
                 while (dividend >= divisor) {
                     dividend = dividend - divisor;
                     i++;
                 }
                 return -i;
             }

         }
         return i;

     }


        public static void main(String[] args) throws IOException {
int dividend = -1;
int divisor =1;
System.out.println(dividend>>>2);
            System.out.println(dividend>>2);
           // System.out.println(dividend<<<1);
            System.out.println(dividend<<2);
            System.out.println(Math.pow(2,16));

          //  1111111111111111

//int out = divide(dividend, divisor);
//                System.out.print(out);
            }
    }

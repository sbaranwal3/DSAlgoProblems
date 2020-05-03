package miscellaneous;

/*
Given an array of distinct elements and a number x, find if there is a pair with a product equal to x.

Examples :

Input : arr[] = {10, 20, 9, 40};
        int x = 400;
Output : Yes

Input : arr[] = {10, 20, 9, 40};
        int x = 190;
Output : No

Input : arr[] = {-10, 20, 9, -40};
        int x = 400;
Output : Yes

Input : arr[] = {-10, 20, 9, 40};
        int x = -400;
Output : Yes

Input : arr[] = {0, 20, 9, 40};
        int x = 0;
Output : Yes
 */

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenProduct {
    //O(n2) time complexity & O(1) space
    static boolean isProductApproach1(int arr[], int n, int x) {
        if (n < 2)
            return false;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] * arr[j] == x)
                    return true;
        return false;
    }


    //O(n) time complexity & O(n) space
    static boolean isProductApproach2(int arr[], int n, int x) {
        Set<Integer> set = new HashSet<>();
        if (n < 2)
            return false;
        for (int i = 0; i < n; i++) {
            //Handling explicitly for arr[i]==0 to avoid x%0 which is undefined
            if (arr[i] == 0) {
                if (x == 0)
                    return true;
                else
                    continue;
            }
            if (x % arr[i] == 0) {
                if (set.contains(x / arr[i]))
                    return true;
                set.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 40};
        int x = 400;
        System.out.println("Does the pair exist? " + isProductApproach1(arr, arr.length, x));
        System.out.println("Does the pair exist? " + isProductApproach2(arr, arr.length, x));
    }
}

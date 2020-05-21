package miscellaneous;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 Write an efficient program for printing first k minimum elements in an array. Elements in array can be in any order.
For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the smallest 3 elements i.e.,
 k = 3 then your program should print 1,2,9
 */
public class FirstKMinElementsFromAnArray {
    private static int[] firstKMin(int[] arr, int k){
        int[] result=new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k; i++)
            result[i]=arr[i];

        return result;
    }

    private static int[] firstKMinUsingQueue(int[] arr, int k){
        int[] result=new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<arr.length; i++)
            queue.offer(arr[i]);

        for(int i=0;i<k; i++)
            result[i]=queue.poll();

        return result;
    }

    public static void main(String[] args) {
        int[] arr= {1, 23, 12, 9, 30, 2, 50};
        int k=3;
        System.out.println("First "+k+" min elements in the array are: "+Arrays.toString(firstKMin(arr, k)));
        System.out.println("First "+k+" min elements in the array using priority queue are: "+Arrays.toString(firstKMinUsingQueue(arr, k)));
    }
}

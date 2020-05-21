package miscellaneous;
/*
Given an array, find count of subarrays with equal no. of evens and odds
 */
public class SubArraysWithEqualNumberOfEvenAndOdd {
    private static int subArraysCount(int[] arr){
        int count=0;
        int diff=0;
for(int i=0; i<arr.length; i++){
    for(int j=i; j<arr.length; j++){
if(arr[j]%2==0)
    diff++;
else
    diff--;
        if(diff==0)
            count++;
    }
    diff=0;
}
return count;
    }

    static int subArraysCountApproach2(int[] arr) {
        // initialize difference
        // and answer with 0
        int difference = 0;
        int ans = 0;

        // create two auxiliary hash
        // arrays to count frequency
        // of difference, one array
        // for non-negative difference
        // and other array for negative
        // difference. Size of these
        // two auxiliary arrays is 'n+1'
        // because difference can
        // reach maximum value 'n' as
        // well as minimum value '-n'
        // initialize these
        // auxiliary arrays with 0
        int[] hash_positive = new int[arr.length + 1];
        int[] hash_negative = new int[arr.length + 1];

        // since the difference is
        // initially 0, we have to
        // initialize hash_positive[0] with 1
        hash_positive[0] = 1;

        // for loop to iterate
        // through whole array
        // (zero-based indexing is used)
        for (int i = 0; i < arr.length; i++) {
            // incrementing or decrementing
            // difference based on
            // arr[i] being even or odd,
            // check if arr[i] is odd
            if (arr[i]%2 == 1) {
                difference++;
            } else {
                difference--;
            }

            // adding hash value of 'difference'
            // to our answer as all the previous
            // occurrences of the same difference
            // value will make even-odd subarray
            // ending at index 'i'. After that,
            // we will increment hash array for
            // that 'difference' value for its
            // occurrence at index 'i'. if
            // difference is negative then use
            // hash_negative
            if (difference < 0) {
                ans += hash_negative[-difference];
                hash_negative[-difference]++;
            } // else use hash_positive
            else {
                ans += hash_positive[difference];
                hash_positive[difference]++;
            }
        }

        // return total number
        // of even-odd subarrays
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println("Total no. of subarrays with equal no. of even & odd numbers are: "+subArraysCount(arr));
        System.out.println("Total no. of subarrays with equal no. of even & odd numbers using approach2 are: "+subArraysCountApproach2(arr));
    }
}

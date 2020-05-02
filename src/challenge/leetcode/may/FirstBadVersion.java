package challenge.leetcode.may;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */

public class FirstBadVersion {
    //Approach 1
    public int firstBadVersionApproach1(int n) {
        return fBV(1, n);
    }

    int fBV(int start, int end){
        if(start == end)
            return start;
        int mid = start + (end-start)/2;
        if(isBadVersion(mid))
            return fBV(start, mid);
        return fBV(mid+1, end);
    }

    private boolean isBadVersion(int mid) {
        return true;
    }


    //Approach 2
    private int firstBadVersionApproach2(int n){
         int s=1, e = n;
         while(s<e){
             int mid = s+(e-s)/2;
             if(isBadVersion(mid))
                 e = mid;
             else
                 s= mid+1;
         }
         return s;
    }

}

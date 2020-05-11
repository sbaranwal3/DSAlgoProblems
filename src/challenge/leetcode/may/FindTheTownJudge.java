package challenge.leetcode.may;

/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 */

import java.util.*;

public class FindTheTownJudge {
    //Time complexity O(N), space complexity 3*O(N)
    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;
        Set<Integer> set = new HashSet<>();
        List<Integer> trustees;
        Map<Integer, List<Integer>> trustMap = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            if (trustMap.containsKey(trust[i][1])) {
                trustees = trustMap.get(trust[i][1]);
            } else {
                trustees = new ArrayList<>();
            }
            trustees.add(trust[i][0]);
            trustMap.put(trust[i][1], trustees);
            set.add(trust[i][0]);
        }

        for (int j = 1; j <= N; j++) {
            //if town judge is present in the trust:member map,
            // check if all except him are the trustees.
            // Also, judge should not trust anyone else. So check if judge is not among the trustees
            if (trustMap.containsKey(j) && trustMap.get(j).size() == N - 1 && !set.contains(j))
                return j;
        }
        return -1;
    }

    public static int findJudgeApproach2(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;
        int[] trustCount = new int[N+1];
        //Keep track of trustCount for each of the trustees
        //Whenever there is a member who has trust on someone, decrease his trust count
        // and increase that person's trust count whom he trusts
        for (int i = 0; i < trust.length; i++) {
            trustCount[trust[i][0]]--;
            trustCount[trust[i][1]]++;
        }
        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (trustCount[i] == N - 1)
                return i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] trust = {{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}};
        int N = 4;
        System.out.println("Label of the town judge is: " + findJudge(N, trust));
        System.out.println("Label of the town judge using Approach2 is: " + findJudgeApproach2(N, trust));

    }
}

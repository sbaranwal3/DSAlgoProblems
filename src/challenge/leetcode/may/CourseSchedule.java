package challenge.leetcode.may;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(adj, visited, i))
                return false;
        }
        return true;
    }

    private static boolean dfs(List<Integer>[] adj, int[] visited, int v) {
        if (visited[v] == 1)
            return false;
        visited[v] = 1;
        for (int ad : adj[v])
            if (!dfs(adj, visited, ad))
                return false;
        visited[v] = 2;

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1},{1,0}};
        System.out.println("Is it possible to finish all the courses for the given number of courses & prerequisites? "+canFinish(numCourses, prerequisites));
    }

}

/*
0---> unvisited
1---> being visited
2---> completed
 */

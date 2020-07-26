package challenge.leetcode.july;

/*
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path);
        return ans;
    }

    public static void dfs(int[][] graph, int u, List<Integer> path) {
        path.add(u);
        if (u == graph.length - 1)
            ans.add(new ArrayList<>(path));
        else
            for (int v : graph[u])
                dfs(graph, v, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        System.out.println("All possible paths from node 0 to node N-1 are: ");
        for (List<Integer> level : result)
            System.out.println(Arrays.toString(level.toArray()));
    }
}

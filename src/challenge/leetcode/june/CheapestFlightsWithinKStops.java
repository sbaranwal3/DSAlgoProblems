package challenge.leetcode.june;

/*
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.


Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
 */

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
                List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
                //creating adjacency list for source cities.
                for (int i = 0; i < n; i++) {
                    graph.add(new ArrayList<>());
                }
                for (int[] flight : flights) {
                    //source city: [destination city, source to destination cost].
                    graph.get(flight[0]).add(new Pair<>(flight[1], flight[2]));
                }
                //MinHeap: input format: [city, distance, cost], it compares based on cost.
                PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
                minHeap.add(new int[]{src, 0, 0});
                while (!minHeap.isEmpty()) {
                    int[] cur = minHeap.poll();
                    int city = cur[0], distance = cur[1], cost = cur[2];
                    if (city == dst) {
                        return cost;
                    }
                    if (distance <= K) {
                        //add adjacent nodes.
                        for (Pair<Integer, Integer> adjNode : graph.get(city)) {
                            minHeap.add(new int[]{adjNode.getKey(), distance + 1, cost + adjNode.getValue()});
                        }
                    }
                }
                return -1;
            }

    public static void main(String[] args) {
        int n=3;
        int src=0, dst=2, k=0;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println("Cheapest price from "+src+" to "+ dst+" with up to "+k+" stops is: "+findCheapestPrice(n, flights, src, dst, k));
    }
}

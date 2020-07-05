package challenge.leetcode.june;

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */

import java.util.*;

//Note: This is an application of Hierholzer’s algorithm to find a Eulerian path https://en.wikipedia.org/wiki/Eulerian_path

public class ReconstructItinerary {
    static Map<String, PriorityQueue<String>> flights;
    static LinkedList<String> path;

    public static List<String> findItinerary(List<List<String>> tickets) {
        // Initialization
        flights = new HashMap<>();
        path = new LinkedList<>();

        // build graph
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");// dfs call from starting airport JFK
        return path;
    }

    public static void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK","SFO"),Arrays.asList("JFK","ATL"),Arrays.asList("SFO","ATL"),Arrays.asList("ATL","JFK"),Arrays.asList("ATL","SFO"));
        System.out.println("Reconstructed itinerary in order is: "+Arrays.toString(findItinerary(tickets).toArray()));
    }
}

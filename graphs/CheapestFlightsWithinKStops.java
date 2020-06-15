// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.HashMap;
import java.util.ArrayList;

// Idea was to find all paths using DFS, but it TLE'd for massive test cases
public class CheapestFlightsWithinKStops {
    HashMap<Integer, ArrayList<int[]>> adjList;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        adjList = new HashMap<Integer, ArrayList<int[]>>();
        
        // Initialize lists for each vertex
        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<int[]>());
        
        // Add flights to adjacency list
        for (int[] flight : flights)
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});

        return dfs(src, dst, 0, K);
    }
    
    public int dfs(int currNode, int dst, int stops, int K) {
        if (currNode == dst)
            return 0;  
        else if (stops > K)
            return -1;
        
        int minPrice = Integer.MAX_VALUE;
        int price;
        for (int[] neighbor : adjList.get(currNode)) {
            if (neighbor[1] > minPrice)
                continue;
            price = dfs(neighbor[0], dst, stops + 1, K);
            if (neighbor[1] + price > minPrice)
                continue;
            if (price != -1)
                minPrice = Math.min(minPrice, neighbor[1] + price);
        }
        
        return (minPrice == Integer.MAX_VALUE) ? -1 : minPrice;
    }
}

/* Accepted solution (from lee215) is the same idea as Dijkstra's
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
    for (int[] f : flights) {
        if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
        prices.get(f[0]).put(f[1], f[2]);
    }
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
    pq.add(new int[] {0, src, k + 1});
    while (!pq.isEmpty()) {
        int[] top = pq.remove();
        int price = top[0];
        int city = top[1];
        int stops = top[2];
        if (city == dst) return price;
        if (stops > 0) {
            Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
            for (int a : adj.keySet()) {
                pq.add(new int[] {price + adj.get(a), a, stops - 1});
            }
        }
    }
    return -1;
} */
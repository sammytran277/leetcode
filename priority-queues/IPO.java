// https://leetcode.com/problems/ipo/

import java.util.*;

public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Profits[b] - Profits[a]);
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> Capital[a] - Capital[b]);
        
        for (int i = 0; i < Capital.length; i++) {
            if (Capital[i] <= W) {
                maxHeap.add(i);
            } else {
                minHeap.add(i);
            }
        }
        
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                return W;
            }
            
            W += Profits[maxHeap.poll()];
            while (!minHeap.isEmpty() && Capital[minHeap.peek()] <= W) {
                maxHeap.add(minHeap.poll());
            }
        }
        
        return W;
    }
}
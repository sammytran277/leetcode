// https://leetcode.com/problems/sliding-window-median/

import java.util.*;

public class SlidingWindowMedian {
    Queue<Long> small = new PriorityQueue<Long>(Collections.reverseOrder());
    Queue<Long> large = new PriorityQueue<Long>();
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int N = nums.length - k + 1;
        if (N < 0) {
            return new double[0];
        }
        
        int start = 0;
        double[] result = new double[N];
        
        // Sliding window
        for (int end = 0; end < nums.length; end++) {
            add(nums[end]);
            
            // Shrink left side of window
            if (end - start + 1 > k) {
                remove(nums[start]);
                start++;
            }
            
            // Calculate median
            if (end - start + 1 == k) {
                result[start] = getMedian();
            }
        }
        
        return result;
    }
    
    public void add(int n) {
        // Add depending on how n compares to current median
        if (n < getMedian()) {
            small.add((long) n);
        } else {
            large.add((long) n);
        }
        
        rebalance();
    }
    
    public void remove(int n) {
        // Remove depending on how n compares to current median
        if (n < getMedian()) {
            small.remove((long) n);
        } else {
            large.remove((long) n);
        }
        
        rebalance();
    }
    
    public double getMedian() {
        if (small.isEmpty() && large.isEmpty()) {
            return 0;
        } else if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return (double) large.peek();
        }
    }
    
    public void rebalance() {
        // large should always be the same size or one larger than small
        if (small.size() > large.size()) {
            large.add(small.poll());
        }
        
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }
}
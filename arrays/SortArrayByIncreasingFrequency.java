// https://leetcode.com/problems/sort-array-by-increasing-frequency/

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Integer.compare(freq.get(a), freq.get(b)) != 0) {
                return Integer.compare(freq.get(a), freq.get(b));
            }
            
            return Integer.compare(b, a);
        });
        
        for (int num : freq.keySet()) {
            pq.add(num);
        }
        
        int i = 0;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (int j = 0; j < freq.get(current); j++) {
                nums[i] = current;
                i++;
            }
        }
            
        return nums;
    }
}
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (numFreq.get(a) > numFreq.get(b))
                    return -1;
                else if (numFreq.get(a) < numFreq.get(b)) 
                    return 1;
                else
                    return 0;
            }
        });
        
        for (int key : numFreq.keySet()) {
            pq.add(key);
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}
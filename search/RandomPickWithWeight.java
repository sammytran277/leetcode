// https://leetcode.com/problems/random-pick-with-weight/

import java.util.Random;
import java.util.HashMap;

public class RandomPickWithWeight {
    int n;
    int maxValue = 0;
    Random r = new Random();
    HashMap<Integer, Integer> indexToWeight = new HashMap<Integer, Integer>();
    public RandomPickWithWeight(int[] w) {
        n = w.length;
        for (int i = 0; i < n; i++) {
            maxValue += w[i];
            indexToWeight.put(i, maxValue);
        }
    }
    
    /* Idea is to generate a number from [1, sum(w)] and use 
       binary search to find the corresponding index because 
       the bounds are actually in "sorted" order */
    public int pickIndex() {
        int randomNumber = r.nextInt(maxValue) + 1;
        return binarySearch(randomNumber);
    }
    
    public int binarySearch(int r) {
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (r <= indexToWeight.get(mid)) {
                if (mid == 0 || r > indexToWeight.get(mid - 1))
                    return mid;
                else
                    right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
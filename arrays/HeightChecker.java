// https://leetcode.com/problems/height-checker/

import java.util.*;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                count++;
            }
        }
        
        return count;
    }
}
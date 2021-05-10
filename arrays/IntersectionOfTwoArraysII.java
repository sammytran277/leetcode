// https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        for (int num : nums1) {
            map[num]++;
        }
        
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map[num] > 0) {
                intersection.add(num);
            }
            
            map[num]--;
        }
        
        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        
        return res;
    }
}
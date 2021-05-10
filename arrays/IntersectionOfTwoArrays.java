// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
                set.remove(num);
            }
        }
        
        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        
        return res;
    }
}
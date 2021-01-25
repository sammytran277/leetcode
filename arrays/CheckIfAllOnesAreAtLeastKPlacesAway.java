// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

import java.util.*;

public class CheckIfAllOnesAreAtLeastKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                A.add(i);
            }
        }
        
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i + 1) - A.get(i) - 1 < k) {
                return false;
            }
        }
        
        return true;
    }    
}

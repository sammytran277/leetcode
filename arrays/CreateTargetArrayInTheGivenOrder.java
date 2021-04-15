// https://leetcode.com/problems/create-target-array-in-the-given-order/

import java.util.*;

public class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = target.get(i);
        }
        
        return res;
    }
}    

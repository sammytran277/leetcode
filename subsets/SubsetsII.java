// https://leetcode.com/problems/subsets-ii/

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);
        
        int lastN = 0;
        for (int i = 0; i < nums.length; i++) {
            int N = subsets.size();
            int start = (i > 0 && nums[i] == nums[i - 1]) ? lastN : 0;
            for (int j = start; j < N; j++) {
                List<Integer> subset = new ArrayList<Integer>(subsets.get(j));
                subset.add(nums[i]);
                subsets.add(subset);
            }
            
            lastN = N;
        }
                                
        return subsets;
    }
}
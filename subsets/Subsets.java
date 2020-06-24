// https://leetcode.com/problems/subsets/

import java.util.List;
import java.util.ArrayList;

public class Subsets {
    // Iterative BFS to generate the power set
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        
        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }
        
        return subsets;
    }
}


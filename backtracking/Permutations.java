// https://leetcode.com/problems/permutations/

import java.util.*;

public class Permutations {
    private int n;
    private boolean[] chosen;
    private List<List<Integer>> permutations;
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        chosen = new boolean[n];
        permutations = new ArrayList<>();
        
        backtrack(nums, new ArrayList<>());
        
        return permutations;
    }
    
    public void backtrack(int[] nums, List<Integer> permutation) {
        if (permutation.size() == n) {
            permutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < n; i++) {
                if (chosen[i]) {
                    continue;
                }
                
                chosen[i] = true;
                permutation.add(nums[i]);
                
                backtrack(nums, permutation);
                
                chosen[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
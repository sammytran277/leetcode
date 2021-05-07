// https://leetcode.com/problems/combination-sum/

import java.util.*;

public class CombinationSum {
    private List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    
    public void backtrack(int[] candidates, int target, int start, int currSum, List<Integer> temp) {
        if (currSum > target) {
            return;
        } else if (currSum == target) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                currSum += candidates[i];
                
                backtrack(candidates, target, i, currSum, temp);
                
                temp.remove(temp.size() - 1);
                currSum -= candidates[i];
            }   
        }
    }
}
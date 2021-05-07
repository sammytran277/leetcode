// https://leetcode.com/problems/combinations/

import java.util.*;

public class Combinations {
    private List<List<Integer>> combinations;
    
    public List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>());
        return combinations;
    }
    
    public void backtrack(int n, int k, int start, List<Integer> temp) {
        if (temp.size() == k) {
            combinations.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= n; i++) {
                temp.add(i);
                backtrack(n, k, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
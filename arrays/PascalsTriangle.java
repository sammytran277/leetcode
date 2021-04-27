// https://leetcode.com/problems/pascals-triangle/

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Collections.singletonList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                int left = (j - 1 >= 0) ? res.get(i - 1).get(j - 1) : 0;
                int right = (j < i) ? res.get(i - 1).get(j) : 0;
                row.add(left + right);
            }
            
            res.add(row);
        }
        
        return res;
    } 
}

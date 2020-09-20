// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        
        List<Integer> ans = new ArrayList<>(); 
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                ans.add(A[j]);
            }
        }
        
        return ans;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
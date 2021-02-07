// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

import java.util.*;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        LinkedList<Integer> A = new LinkedList<Integer>();
        for (int num : nums) {
            A.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            A.addFirst(A.pollLast());
            if (isSorted(A)) {
                return true;
            }
        }
        
        return false;
    }

    public boolean isSorted(LinkedList<Integer> A) {
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }    
}

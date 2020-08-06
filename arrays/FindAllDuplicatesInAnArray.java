// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num: nums) {
            if (!unique.contains(num))
                unique.add(num);
            else
                duplicates.add(num);
        }
        
        return duplicates;
    }
}
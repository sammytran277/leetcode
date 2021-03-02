// https://leetcode.com/problems/distribute-candies/

import java.util.*;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) {
            set.add(type);
        }
        
        int n = candyType.length;
        return (set.size() >= n / 2) ? n / 2 : set.size();
    }
}
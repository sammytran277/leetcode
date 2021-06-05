// https://leetcode.com/problems/finding-the-users-active-minutes/

import java.util.*;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        
        int[] res = new int[k];
        for (Set<Integer> set : map.values()) {
            res[set.size() - 1]++;
        }
        
        return res;
    }    
}

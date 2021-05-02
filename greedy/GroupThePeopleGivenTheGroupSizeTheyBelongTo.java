// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/ 

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            
            List<Integer> currGroup = map.get(groupSizes[i]);
            currGroup.add(i);
            if (groupSizes[i] == currGroup.size()) {
                res.add(currGroup);
                map.put(groupSizes[i], new ArrayList<>());
            }
        }
        
        return res;
    }    
}

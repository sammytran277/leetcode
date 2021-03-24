// https://leetcode.com/problems/count-items-matching-a-rule/

import java.util.*;

public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int key = (ruleKey.equals("type")) ? 0 : (ruleKey.equals("color")) ? 1 : 2;
        int count = 0;
        for (List<String> item : items) {
            if (item.get(key).equals(ruleValue)) {
                count++;
            }
        }
        
        return count;
    }    
}

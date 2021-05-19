// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/ 

import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            uf.parent.put(s, s);
        }
        
        for (int[] stone1 : stones) {
            String s1 = stone1[0] + " " + stone1[1];
            for (int[] stone2 : stones) {
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    String s2 = stone2[0] + " " + stone2[1];
                    uf.union(s1, s2);
                }
            }
        }
        
        return stones.length - uf.numSets;
    }
    
    private class UnionFind {
        public Map<String, String> parent;
        public int numSets;
        
        public UnionFind(int n) {
            parent = new HashMap<>();
            numSets = n;
        }
        
        public String find(String s) {
            if (s.equals(parent.get(s))) {
                return s;
            }
            
            parent.put(s, find(parent.get(s)));
            return parent.get(s);
        }
        
        public void union(String s1, String s2) {
            String s1Root = find(s1);
            String s2Root = find(s2);
            if (!s1Root.equals(s2Root)) {
                parent.put(s2Root, s1Root);
                numSets--;
            }
        }
    }   
}

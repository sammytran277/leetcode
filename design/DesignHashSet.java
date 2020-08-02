// https://leetcode.com/problems/design-hashset/

import java.util.ArrayList;

public class DesignHashSet {
    /** Initialize your data structure here. */
    ArrayList<ArrayList<Integer>> table;
    public DesignHashSet() {
        table = new ArrayList<ArrayList<Integer>>(100);
        for (int i = 0; i < 100; i++) {
            table.add(new ArrayList<Integer>());
        }
    }
    
    public int hash(int key) {
        return key % 100;
    }
    
    public void add(int key) {
        int h = hash(key);
        if (!table.get(h).contains(key)) {
            table.get(h).add(key);
        }
    }
    
    public void remove(int key) {
        int h = hash(key);
        if (table.get(h).contains(key)) {
            table.get(h).remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        return table.get(h).contains(key);
    }
}



// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    /* RandomSet will be created with an ArrayList (for indexing)
       and a HashMap (for O(1) lookup) */
    ArrayList<Integer> A;
    Random r;
    HashMap<Integer, Integer> valToIndex;
    public InsertDeleteGetRandom() {
        A = new ArrayList<Integer>();
        r = new Random();
        valToIndex = new HashMap<Integer, Integer>();
    }
    
    // Add val to end of ArrayList and create key-value pair
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
            
        valToIndex.put(val, A.size());
        A.add(val);
        return true;
    }
    
    /* To remove in O(1) time, swap the value 
       to remove with the last item in the ArrayList */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        
        int lastIndex = A.size() - 1;
        int lastVal = A.get(lastIndex);
        
        A.set(valToIndex.get(val), lastVal);
        valToIndex.put(lastVal, valToIndex.get(val));
        A.remove(lastIndex);
        valToIndex.remove(val);
        return true;
    }
    
    // Return a random index from [0, n), where n = A.size()
    public int getRandom() {
        return A.get(r.nextInt(A.size()));
    }
}
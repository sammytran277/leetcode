// https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;

public class FruitsIntoBaskets {
    // Same as finding the longest substring with 2 distinct characters
    public int totalFruit(int[] tree) {
        int i = 0, j = 0, n = tree.length, maxFruit = 0;
        HashMap<Integer, Integer> fruitFreq = new HashMap<Integer, Integer>();
        while (j < n) {
            fruitFreq.put(tree[j], fruitFreq.getOrDefault(tree[j], 0) + 1);
            while (fruitFreq.size() > 2) {
                fruitFreq.put(tree[i], fruitFreq.get(tree[i]) - 1);
                if (fruitFreq.get(tree[i]) == 0)
                    fruitFreq.remove(tree[i]);
                i++;
            }
    
            maxFruit = Math.max(maxFruit, j - i + 1);
            j++;
        }
    
        return maxFruit;
    }
}
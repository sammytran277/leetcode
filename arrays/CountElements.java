// Link to be added (new problem)

import java.util.HashMap;

public class CountElements 
{
    public int countElements(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> intFreq = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
        {
            if (intFreq.containsKey(arr[i]))
                intFreq.put(arr[i], intFreq.get(arr[i]) + 1);
            else
                intFreq.put(arr[i], 1);
        }
        
        int count = 0;
        for (int key : intFreq.keySet())
        {
            if (intFreq.containsKey(key + 1))
                count += intFreq.get(key); 
        }
        
        return count;
    }
}
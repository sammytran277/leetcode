// https://leetcode.com/problems/majority-element/

public class MajorityElement
{
    public int majorityElement(int[] nums) 
    {
        int n = nums.length;
        HashMap<Integer, Integer> intFreq = new HashMap<Integer, Integer>();

        for (int num : nums)
            intFreq.put(num, intFreq.getOrDefault(num, 0) + 1);
        
        for (int key : intFreq.keySet()) {
            if (intFreq.get(key) > Math.floor(n / 2))
                return key;
        }
        
        return -1;
    }
}
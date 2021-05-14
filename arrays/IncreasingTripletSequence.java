// https://leetcode.com/problems/increasing-triplet-subsequence/

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int nextSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= smallest) {
                smallest = num;
            } else if (num <= nextSmallest) {
                nextSmallest = num;
            } else {
                return true;
            }
        }
        
        return false;
    }

// A more intuitive approach using a prefix min and suffix max array
//     public boolean increasingTriplet(int[] nums) {
//         int n = nums.length;
        
//         int min = Integer.MAX_VALUE;
//         int[] minBefore = new int[n];
//         for (int i = 0; i < n; i++) {
//             minBefore[i] = min;
//             min = Math.min(min, nums[i]);
//         }
        
//         int max = Integer.MIN_VALUE;
//         int[] maxAfter = new int[n];
//         for (int i = n - 1; i >= 0; i--) {
//             maxAfter[i] = max;
//             max = Math.max(max, nums[i]);
//         }
        
//         for (int i = 0; i < n; i++) {
//             if (minBefore[i] < nums[i] && nums[i] < maxAfter[i]) {
//                 return true;
//             }
//         }
        
//         return false;
//     }    
}

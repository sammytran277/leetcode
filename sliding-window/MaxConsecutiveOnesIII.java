public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int k) {
        int n = A.length;
        int start = 0;
        int longest = 0;
        int onesCount = 0;
        
        // Keep track of the number of ones and make sure there are <= k zeroes
        for (int end = 0; end < n; end++) {
            if (A[end] == 1)
                onesCount++;
            
            // Shrink the window while there are more zeroes than k
            while (end - start + 1 - onesCount > k) {
                if (A[start] == 1)
                    onesCount--;
                start++;
            }
    
            longest = Math.max(longest, end - start + 1);
        }
    
        return longest;
    }  
}


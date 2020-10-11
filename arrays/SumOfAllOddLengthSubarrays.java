// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] A) {
        int sum = 0;
        for (int i = 1; i <= A.length; i += 2) {
            sum += subarraySum(A, i);
        }
        
        return sum;
    }
    
    public int subarraySum(int[] A, int size) {
        int subarraySum = 0;
        int windowSum = 0;
        int start = 0;
        
        for (int end = 0; end < A.length; end++) {
            windowSum += A[end];
            if (end - start + 1 > size) {
                windowSum -= A[start];
                start++;
            }
            
            if (end - start + 1 == size) {
                subarraySum += windowSum;
            }
        }
        
        return subarraySum;
    }
}
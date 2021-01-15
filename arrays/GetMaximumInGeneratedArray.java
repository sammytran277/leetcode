// https://leetcode.com/problems/get-maximum-in-generated-array/

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] A = new int[n + 1];
        A[1] = 1;
        int max = 1;
        for (int i = 0; i <= n / 2; i++) {
            A[2 * i] = A[i];
            if (2 * i + 1 < n + 1) {
                A[2 * i + 1] = A[i] + A[i + 1];
                max = Math.max(max, A[i] + A[i + 1]);
            }

        }
        
        return max;
    }    
}

// https://leetcode.com/problems/reordered-power-of-2/

public class ReorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int N) {
        int[] digitFreq = new int[10];
        while (N > 0) {
            digitFreq[N % 10]++;
            N /= 10;
        }
        
        outer: for (int i = 0; i < 32; i++) {
            int M = 1 << i;
            int[] powDigitFreq = new int[10];
            while (M > 0) {
                powDigitFreq[M % 10]++;
                M /= 10;
            }
            
            for (int j = 0; j < 10; j++) {
                if (digitFreq[j] != powDigitFreq[j]) {
                    continue outer;
                }
            }
            
            return true;
        }
        
        return false;
    }
}
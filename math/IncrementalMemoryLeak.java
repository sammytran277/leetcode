// https://leetcode.com/problems/incremental-memory-leak/

public class IncrementalMemoryLeak {
    public int[] memLeak(int m1, int m2) {
        int i = 1;
        while (true) {
            if (m1 >= m2 && m1 - i >= 0) {
                m1 -= i;
            } else if (m2 - i >= 0) {
                m2 -= i;
            } else {
                return new int[]{i, m1, m2};
            }
            
            i++;
        }
    }    
}

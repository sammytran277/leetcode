// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

import java.util.Arrays;

public class ArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int step = arr[1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] != step)
                return false;
        }
        
        return true;
    }
}
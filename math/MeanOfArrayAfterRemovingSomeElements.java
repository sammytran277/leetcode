// https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

import java.util.*;

public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {        
        Arrays.sort(arr);
        
        int skip = arr.length / 20;
        double sum = 0;
        for (int i = skip; i < arr.length - skip; i++) {
            sum += arr[i];
        }
        
        return sum / (arr.length - 2 * skip);
    }
}
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int maxIndex = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }    
}

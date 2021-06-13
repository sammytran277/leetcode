// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/

public class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] isCovered = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isCovered[i] = true;
            }
        }
        
        for (int i = left; i <= right; i++) {
            if (!isCovered[i]) {
                return false;
            }
        }
        
        return true;
    }
}
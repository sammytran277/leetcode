// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        for (int[] rect : rectangles) {
            maxLen = Math.max(maxLen, Math.min(rect[0], rect[1]));
        }
        
        int result = 0;
        for (int[] rect : rectangles) {
            if (Math.min(rect[0], rect[1]) == maxLen) {
                result++;
            }
        }

        return result;
    }    
}

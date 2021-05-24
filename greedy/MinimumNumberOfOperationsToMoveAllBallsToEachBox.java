// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int numBalls = 0;
        
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 >= 0) ? prefix[i - 1] : 0;
            prefix[i] = prev + numBalls;
            if (boxes.charAt(i) == '1') {
                numBalls++;
            }
        }
        
        numBalls = 0;
        int[] suffix = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int next = (i + 1 < n - 1) ? suffix[i + 1] : 0;
            suffix[i] = next + numBalls;
            if (boxes.charAt(i) == '1') {
                numBalls++;
            }
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] + suffix[i];
        }
        
        return res;
    }    
}

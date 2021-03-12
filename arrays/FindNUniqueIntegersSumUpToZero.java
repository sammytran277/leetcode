// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++) {
            ans[2 * i] = (i + 1);
            ans[2 * i + 1] = -(i + 1);
        }
        
        return ans;
    }
}
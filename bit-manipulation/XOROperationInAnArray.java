// https://leetcode.com/problems/xor-operation-in-an-array/

public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= (2* i) + start;
        }

        return ans;
    }    
}

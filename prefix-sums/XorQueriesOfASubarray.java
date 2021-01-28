// https://leetcode.com/problems/xor-queries-of-a-subarray/

public class XorQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int[] q = queries[i];
            res[i] = prefix[q[0]] ^ prefix[q[1] + 1];
        }
        
        return res;
    }    
}

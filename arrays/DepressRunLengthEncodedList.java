// https://leetcode.com/problems/decompress-run-length-encoded-list/

public class DepressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i += 2) {
            n += nums[i];
        }
        
        int ptr = 0;
        int[] res = new int[n];
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[ptr++] = nums[i + 1];
            }
        }
        
        return res;
    }    
}

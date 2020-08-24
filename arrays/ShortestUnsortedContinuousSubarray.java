// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();

        Arrays.sort(temp);
        int i = 0;
        int j = n - 1;

        while (i < n && nums[i] == temp[i]) {
            i++;
        }

        while (j >= 0 && nums[j] == temp[j]) {
            j--;
        }

        return (i < j) ? j - i + 1 : 0;
    }
}   
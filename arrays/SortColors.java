// https://leetcode.com/problems/sort-colors/

public class SortColors {

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length;

        // Three-way partitioning
        while (j < k) {
            if (nums[j] == 0)
                swap(nums, j++, i++);
            else if (nums[j] == 1)
                j++;
            else
                swap(nums, j, --k);
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }    
}
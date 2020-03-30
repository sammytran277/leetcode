// https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        /* i points to middle of nums1, j points to end of nums2, 
           k points to end of num1 */
        int i = m - 1; 
        int j = n - 1; 
        int k = nums1.length - 1;
        while (i >= 0 || j >= 0)
        {
            // i is exhausted
            if (i < 0)
                nums1[k--] = nums2[j--];
            // j is exhausted, but i is already in nums1 and sorted
            else if (j < 0)
                break;
            else if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }
}
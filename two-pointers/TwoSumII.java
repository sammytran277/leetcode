// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class TwoSumII
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int i = 0, j = numbers.length - 1;
        while (i < numbers.length && j >= 0)
        {
            if (numbers[i] + numbers[j] == target)
                break;
            else if (numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        
        return new int[]{i + 1, j + 1};
    }
}
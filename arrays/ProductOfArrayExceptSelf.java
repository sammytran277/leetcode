// https://leetcode.com/problems/product-of-array-except-self/

public class ProductOfArrayExceptSelf 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        // Prefix product
        for (int i = 0; i < nums.length; i++)
            prefix[i] = (i == 0) ? 1 : prefix[i - 1] * nums[i - 1];
        
        // Suffix product
        for (int i = nums.length - 1; i >= 0; i--)
            suffix[i] = (i == nums.length - 1) ? 1 : suffix[i + 1] * nums[i + 1];
        
        // Product except self is product of prefix and suffix
        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            if (i == 0)
                product[i] = suffix[i];
            else if (i == nums.length - 1)
                product[i] = prefix[i];
            else
                product[i] = prefix[i] * suffix[i];
        }

        return product;
    }
}
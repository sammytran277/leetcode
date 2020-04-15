// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductOfArrayExceptSelf 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] products = new int[nums.length];
        Arrays.fill(products, 1);
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1)
                continue;
            for (int j = 0; j < nums.length; j++)
            {
                if (i == j)
                    continue;
                products[j] *= nums[i];
            }
        }

        return products;
    }
}
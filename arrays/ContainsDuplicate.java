// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate
{
    public static boolean containsDuplicate(int[] nums) 
    {
        HashSet<Integer> intFrequency = new HashSet<Integer>();
        for (int n : nums)
        {
            if (intFrequency.contains(n))
                return true;
            else
                intFrequency.add(n);
        }
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the array length: ");
        int arrayLength = s.nextInt();

        System.out.print("Enter the array values: ");
        int[] a = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++)
            a[i] = s.nextInt();

        System.out.println("Contains duplicates? " + containsDuplicate(a));

        s.close();
    }
}
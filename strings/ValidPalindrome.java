// https://leetcode.com/problems/valid-palindrome/

import java.util.Scanner;

public class ValidPalindrome 
{
    public static boolean isPalindrome(String s) 
    {
        int i = 0, j = s.length() - 1;
        String lower = s.toLowerCase();
        while (i < j)
        {
            if (!Character.isLetterOrDigit(lower.charAt(i)))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(lower.charAt(j)))
            {
                j--;
                continue;
            }
                if (lower.charAt(i++) != lower.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the string to test: ");
        String str = s.nextLine();
        System.out.println("Valid palindrome? " + isPalindrome(str));

        s.close();
    }
}
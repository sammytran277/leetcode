// https://leetcode.com/problems/reverse-string/

import java.util.Scanner;

public class ReverseString
{
    public static void reverseString(char[] s) 
    {
        int i = 0, j = s.length - 1;
        while (i < j)
            swap(s, i++, j--);
    }

    public static void swap(char[] s, int i, int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the string to reverse: ");
        char[] str = s.nextLine().toCharArray();
        reverseString(str);
        System.out.println("Reversed string: " + new String(str));

        s.close();
    }
}
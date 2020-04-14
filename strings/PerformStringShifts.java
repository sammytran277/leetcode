// No link ATM

public class PerformStringShifts
{
    public static String stringShift(String s, int[][] shift) 
    {
        /* Idea is to compute the total amount being shifted 
           so we only have to shift the string once */
        int n = s.length();
        int totalShift = 0;
        for (int i = 0; i < shift.length; i++)
        {
            if (shift[i][0] == 0)
                totalShift -= shift[i][1];
            else
                totalShift += shift[i][1];
        }

        /* Right shift uses % to keep indexes valid, left shift formula is
           the VERY unintuitive looking: (n - (s % n) + i) % n */
        char[] shiftedChars = new char[n];
        for (int i = 0; i < n; i++)
        {
            if (i + totalShift < 0)
                shiftedChars[(n - (-1 * totalShift % n) + i) % n] = s.charAt(i);
            else
                shiftedChars[(i + totalShift) % n] = s.charAt(i);
        }

        return String.valueOf(shiftedChars);
    }
}
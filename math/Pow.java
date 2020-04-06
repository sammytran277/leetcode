// https://leetcode.com/problems/powx-n/

public class Pow 
{
    // Calculated using the fast exponentiation formula
    public double myPow(double x, double n) 
    {
        double result;
        
        if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else if (n < 0)
            return 1 / (myPow(x, -1 * n));
        else if (n % 2 == 0)
        {
            result = myPow(x, n / 2);
            return  result * result;
        }
        else
        {
            result = myPow(x, (n - 1) / 2);
            return x * result * result;
        }
    }
}
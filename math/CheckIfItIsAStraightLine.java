// https://leetcode.com/problems/check-if-it-is-a-straight-line/

public class CheckIfItIsAStraightLine 
{
    public boolean checkStraightLine(int[][] coordinates) 
    {
        int n = coordinates.length;
        if (n == 2)
            return true;
        
        float initialY = (float) coordinates[1][1] - coordinates[0][1];
        int initialX = coordinates[1][0] - coordinates[0][0];
        float initialSlope = initialY / initialX;
        float currSlope, currY;
        int currX;
        
        for (int i = 3; i < n; i++) 
        {
            currY = (float) coordinates[i][1] - coordinates[i - 1][1];
            currX = coordinates[i][0] - coordinates[i - 1][0];
            currSlope = currY / currX;
            
            if (Math.abs(initialSlope - currSlope) > 0.0000001)
                return false;
        }
        
        return true;
    }
}
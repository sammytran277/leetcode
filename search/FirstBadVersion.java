// https://leetcode.com/problems/first-bad-version/

public class firstBadVersion extends VersionControl 
{
    public int firstBadVersion(int n) 
    {
        int left = 1, right = n;
        int mid = 0, firstBadVersion = 0;
        while (left <= right) 
        {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) 
            {
                right = mid - 1;
                if (!isBadVersion(mid - 1))
                    return mid;
            }
            else
                left = mid + 1;
        }
        
        return left;
    }
}
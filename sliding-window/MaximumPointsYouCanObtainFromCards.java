// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        
        if (n == k) {
            return sum;
        }
        
        int res = 0;
        int subSum = 0;
        for (int start = 0, end = 0; end < n; end++) {
            subSum += cards[end];
            if (end - start + 1 == n - k) {
                res = Math.max(res, sum - subSum);
                subSum -= cards[start];
                start++;
            }
        }
        
        return res;
    }    
}

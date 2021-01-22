// https://leetcode.com/problems/distribute-candies-to-people/

public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribution = new int[num_people];
        int numToGive = 1;
        int i = 0;
        while (candies > 0) {
            distribution[i] += Math.min(candies, numToGive);
            candies -= Math.min(candies, numToGive);
            numToGive++;
            i = (i + 1) % num_people;
        }
        
        return distribution;
    }    
}

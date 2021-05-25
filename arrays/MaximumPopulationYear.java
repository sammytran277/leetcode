// https://leetcode.com/problems/maximum-population-year/

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        // 1950 to 2050
        int[] map = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                map[i - 1950]++;
            }
        }

        int max = 0;
        for (int population : map) {
            max = Math.max(max, population);
        }
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] == max) {
                return i + 1950;
            }
        }
        
        return -1;
    }    
}

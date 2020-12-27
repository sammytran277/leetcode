// https://leetcode.com/problems/average-waiting-time/

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int i = 0;
        int currTime = 1;
        double timeSum = 0;
        while (i != customers.length) {
            if (currTime >= customers[i][0]) {
                timeSum += currTime - customers[i][0] + customers[i][1];
                currTime += customers[i][1];
                i++;
            } else {
                currTime = customers[i][0];
            }
        }
        
        return timeSum / customers.length;
    }
}
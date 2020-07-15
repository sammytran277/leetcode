// https://leetcode.com/problems/angle-between-hands-of-a-clock/

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour * 30) + (minutes / 2.0);
        double minAngle = (minutes / 60.0) * 12 * 30;
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }
}
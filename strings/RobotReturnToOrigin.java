// https://leetcode.com/problems/robot-return-to-origin/

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else {
                x++;
            }
        }
        
        return x == 0 && y == 0;
    }
}
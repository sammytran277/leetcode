// https://leetcode.com/problems/determine-color-of-a-chessboard-square/

public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        char file = coordinates.charAt(0);
        int rank = coordinates.charAt(1) - '0';
        
        if (file == 'a' || file == 'c' || file == 'e' || file == 'g') {
            return rank % 2 == 0;
        }
        
        return rank % 2 != 0;
    }    
}

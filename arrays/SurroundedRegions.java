// https://leetcode.com/problems/surrounded-regions/

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0)
            return;
        
        int cols = board[0].length;
        
        // Change all O regions connected to border to S
        for (int i = 0; i < cols; i++) {
            save(board, 0, i);
            save(board, rows - 1, i);
        }
        
        for (int i = 0; i < rows; i++) {
            save(board, i, 0);
            save(board, i, cols - 1);
        }
        
        // Change all S to O, everything else will be changed to X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    
    public void save(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return;
        else if (board[r][c] != 'O')
            return;
        
        board[r][c] = 'S';
        save(board, r + 1, c);
        save(board, r - 1, c);
        save(board, r, c + 1);
        save(board, r, c - 1);
    }
}
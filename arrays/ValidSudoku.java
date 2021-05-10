// https://leetcode.com/problems/valid-sudoku/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRowOrCol(board, true, i) || !isValidRowOrCol(board, false, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidRowOrCol(char[][] board, boolean isRow, int j) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; i++) {
            char c = (isRow) ? board[j][i] : board[i][j];
            if (c == '.') {
                continue;
            }
            
            int n = c - '0';
            if (n == 0 || seen[n]) {
                return false;
            }
            
            seen[n] = true;
        }
        
        return true;
    }
    
    public boolean isValidSubBox(char[][] board, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                
                int n = c - '0';
                if (n == 0 || seen[n]) {
                    return false;
                }
                
                seen[n] = true;
            }
        }
        
        return true;
    }    
}

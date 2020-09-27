// https://leetcode.com/problems/game-of-life/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        if (rows == 0)
            return;
        
        int cols = board[0].length;
        int[][] newBoard = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = getLiveNeighbors(board, rows, cols, i, j);
                if (board[i][j] == 1 && liveNeighbors != 2 && liveNeighbors != 3) {
                    newBoard[i][j] = 0;
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    newBoard[i][j] = 1;
                } else {
                    newBoard[i][j] = board[i][j];
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
    
    public int getLiveNeighbors(int[][] board, int numRows, int numCols, int row, int col) {
        int[] directions = {-1, 0, 1};
        int liveNeighbors = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(directions[i] == 0 && directions[j] == 0)) {
                    int newRow = row + directions[i];
                    int newCol = col + directions[j];
                    if (isValidIndex(numRows, numCols, newRow, newCol) && board[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }
            }
        }
        
        return liveNeighbors;
    }
    
    public boolean isValidIndex(int numRows, int numCols, int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
// https://leetcode.com/problems/word-search/

public class WordSearch {
    int n, rows, cols;
    public boolean exist(char[][] board, String word) {
        n = word.length();
        rows = board.length;
        cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int i, int j, int wordPtr) {
        // Found last letter
        if (wordPtr >= n - 1) 
            return true;
        
        // Replace char with dummy value to prevent reuse
        char temp = board[i][j];
        board[i][j] = '0';

        // Check southern neighbor
        if (i + 1 < rows && board[i + 1][j] == word.charAt(wordPtr + 1))
            if (dfs(board, word, i + 1, j, wordPtr + 1)) return true;
        
        // Check northern neighbor
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(wordPtr + 1))
            if (dfs(board, word, i - 1, j, wordPtr + 1)) return true;
        
        // Check eastern neighbor
        if (j + 1 < cols && board[i][j + 1] == word.charAt(wordPtr + 1))
            if (dfs(board, word, i, j + 1, wordPtr + 1)) return true;
        
        // Check western neighbor
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(wordPtr + 1))
            if (dfs(board, word, i, j - 1, wordPtr + 1)) return true;
           
        board[i][j] = temp;
        
        return false;
    }
}

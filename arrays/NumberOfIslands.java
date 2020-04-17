//

public class NumberOfIslands
{
    public static int numIslands(char[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int numIslands = 0;
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
                numIslands += dfs(grid, i, j, m, n);
        }
        
        return numIslands;
    }
    
    public static int dfs(char[][] grid, int i, int j, int m, int n)
    {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
            return 0;
        
        grid[i][j] = '0';
        
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        
        return 1;
    }

    public static void main(String[] args) {
        // char[][] test = new char[][]{
        //     {'1', '1', '1', '0'},
        //     {'1', '1', '0', '1'},
        //     {'0', '0', '0', '1'},
        //     {'0', '1', '0', '1'}
        // };
        // char[][] test = new char[][]{
        //     {'1','1','1','1','0'},
        //     {'1','1','0','1','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','0','0','0'}
        // };
        char[][] test = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };


        System.out.println(numIslands(test));
    }
}
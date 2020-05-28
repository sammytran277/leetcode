// https://leetcode.com/problems/possible-bipartition/

public class PossibleBipartite 
{
    public boolean possibleBipartition(int N, int[][] dislikes) 
    {
        // Represents the graph as an adjacency matrix
        boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) 
        {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
    
        /* Idea is to color a node 1, then all its neighbors -1, 
            then all their neighbors 1, and so on until there is a conflict */
        int[] colors = new int[N];
        for (int i = 0; i < N; i++)
        {
            if (colors[i] == 0 && !paint(i, 1, colors, g))
                return false;
        }
        return true;
    }
   
    boolean paint(int u, int color, int[] colors, boolean[][] g) 
    {
        if (colors[u] != 0)
            return colors[u] == color;
        
        colors[u] = color;
        for (int v = 0; v < colors.length; v++)
        {
            if (g[u][v] && !paint(v, -color, colors, g))
                return false;
        }
        return true;
    }
}
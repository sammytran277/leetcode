// https://leetcode.com/problems/flood-fill/

public class FloodFill  
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) 
    {
        // Check for valid index and if we've already been to this cell
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;
        else if (image[sr][sc] == newColor)
            return;
        
        // Change the old color to the new one
        if (image[sr][sc] == oldColor)
            image[sr][sc] = newColor;
        else
            return;
        
        // Recursively change neighboring cells
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
    }
}
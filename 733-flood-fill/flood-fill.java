class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        helper(image, sr, sc, originalColor, color);
        return image;
    }
    
    public void helper(int[][] image, int i, int j, int originalColor, int color) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != originalColor) {
            return;
        }
        image[i][j] = color;
        helper(image, i - 1, j, originalColor, color);
        helper(image, i + 1, j, originalColor, color);
        helper(image, i, j - 1, originalColor, color);
        helper(image, i, j + 1, originalColor, color);
    }
}

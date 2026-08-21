class Solution {
    int rows;
    int cols;
    void dfs(int row, int col, int newColor, int currColor, int[][] image){
        if(row  < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != currColor || image[row][col] == newColor) return;

        image[row][col] = newColor;
        int[][] adjList = {{row - 1, col}, {row, col + 1}, {row + 1, col}, {row, col - 1}};
        for(int[] neighbour : adjList){
            dfs(neighbour[0], neighbour[1], newColor, currColor, image);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        dfs(sr, sc, color, image[sr][sc], image);
        return image;
    }
}
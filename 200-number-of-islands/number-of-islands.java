class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visit = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    dfs(i,j,visit,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,boolean [][] visit,char [][] grid){
        // if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;

        visit[i][j] = true;

        if(i>0 && !visit[i-1][j] && grid[i-1][j]=='1') dfs(i-1,j,visit,grid);
        if(i<grid.length-1 && !visit[i+1][j] && grid[i+1][j]=='1') dfs(i+1,j,visit,grid);
        if(j>0 && !visit[i][j-1] && grid[i][j-1]=='1') dfs(i,j-1,visit,grid);
        if(j<grid[0].length-1 && !visit[i][j+1] && grid[i][j+1]=='1') dfs(i,j+1,visit,grid);
    }
}
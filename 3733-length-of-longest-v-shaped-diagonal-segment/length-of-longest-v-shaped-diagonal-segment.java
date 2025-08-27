class Solution {
    int [][] d = {{1,1},{1,-1},{-1,-1},{-1,1}};
    int m; int n;
    int [][] grid;
    int [][][][] dp;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        dp = new int[m][n][4][2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int dir=0;dir<4;dir++){
                       ans = Math.max(ans,dfs(i,j,dir,true,2)+1);
                    }
                }
            }
        }
        return ans;
    }

    public int dfs(int x,int y,int dir,boolean turn,int next){
        int nx = x+d[dir][0];
        int ny = y+d[dir][1];
        int res = 0;

        if(nx<0 || nx>=m || ny<0 || ny>=n || grid[nx][ny]!=next) return 0;

        int turnindex = turn?1:0;

        if(dp[x][y][dir][turnindex]!=-1) return dp[x][y][dir][turnindex];

        int max = dfs(nx,ny,dir,turn,2-next);

        if(turn){
            max = Math.max(max,dfs(nx,ny,(dir+1)%4,false,2-next));
        }
        dp[x][y][dir][turnindex] = max+1; 
        return max+1;
    }
}
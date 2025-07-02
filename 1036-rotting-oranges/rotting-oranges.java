class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int maxtime = 0;
        while(q.size()>0){
            int [] mat = q.poll();
            int r = mat[0];
            int c = mat[1];
            int t = mat[2];
            if(r>=1 && grid[r-1][c]==1){
                 q.add(new int[]{r-1,c,t+1});
                 fresh--;
                 grid[r-1][c] = 2;
            }
            if(r<n-1 && grid[r+1][c]==1){
                 q.add(new int[]{r+1,c,t+1});
                 fresh--;
                 grid[r+1][c] = 2;
            }
            if(c>=1 && grid[r][c-1]==1){
                 q.add(new int[]{r,c-1,t+1});
                 fresh--;
                 grid[r][c-1] = 2;
            }
            if(c<m-1 && grid[r][c+1]==1){
                 q.add(new int[]{r,c+1,t+1});
                 fresh--;
                 grid[r][c+1] = 2;
            }
            maxtime = Math.max(maxtime,t);
        }
        if(fresh!=0) return -1;
        return maxtime;
    }
}
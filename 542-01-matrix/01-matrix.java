class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] ans = new int[n][m];
        int [][] visit = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visit[i][j] = 1;
                }
                else visit[i][j] = 0;
            }
        }
        while(q.size()>0){
            int [] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int t = arr[2];
            ans[r][c] = t;
            if(r>0 && visit[r-1][c]==0){
                visit[r-1][c] = 1;
                q.add(new int[]{r-1,c,t+1});
            }
              if(r<n-1 && visit[r+1][c]==0){
                visit[r+1][c] = 1;
                q.add(new int[]{r+1,c,t+1});
            }
              if(c>0 && visit[r][c-1]==0){
                visit[r][c-1] = 1;
                q.add(new int[]{r,c-1,t+1});
            }
              if(c<m-1 && visit[r][c+1]==0){
                visit[r][c+1] = 1;
                q.add(new int[]{r,c+1,t+1});
            }

        }
         return ans;
    }
}
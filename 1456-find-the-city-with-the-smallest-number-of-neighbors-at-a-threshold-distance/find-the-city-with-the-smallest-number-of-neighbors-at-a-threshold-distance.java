class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int [][] mat = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) mat[i][j] =Integer.MAX_VALUE;
        
        for(int i=0;i<edges.length;i++){
           int u = edges[i][0];
           int v = edges[i][1];
           int wt = edges[i][2];

           mat[u][v] = wt;
           mat[v][u] = wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(mat[i][k]!=Integer.MAX_VALUE && mat[k][j]!=Integer.MAX_VALUE){
                        mat[i][j] = Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                    }
                }
            }
        }

        int minVal = Integer.MAX_VALUE;
        int min = -1;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(mat[i][j]<=t) count++;
            }
            if(count<=minVal){
                minVal = count;
                min = i;
            }
        }
        return min;
    }
}
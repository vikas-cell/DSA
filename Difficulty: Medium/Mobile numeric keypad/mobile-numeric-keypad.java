class Solution {
    int count = 0;

    public int getCount(int n) {
        char[][] mat = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'}
        };
        int [][][] dp = new int[n+1][4][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                count += helper(i, j, mat, n,dp);
            }
        }
        return count;
    }

    public int helper(int i, int j, char[][] mat, int n,int [][][] dp) {
        // Base case: valid sequence of length n
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j]=='*' || mat[i][j]=='#') return 0; // Out of bounds
        if(n==1) return 1;
        if(dp[n][i][j]!=-1) return dp[n][i][j];
        // Count the number of valid sequences from the current position
        return dp[n][i][j]=helper(i - 1, j, mat, n - 1,dp) + // Up
               helper(i + 1, j, mat, n - 1,dp) + // Down
               helper(i, j - 1, mat, n - 1,dp) + // Left
               helper(i, j + 1, mat, n - 1,dp)+ // Right
               helper(i,j,mat,n-1,dp); 
    }
}

class Solution {
    public void solve(char[][] nums) {
        int m = nums.length; int n = nums[0].length;
        for(int i=0;i<m;i++){
            if(nums[i][0]=='O') dfs(i,0,nums);
            if(nums[i][n-1]=='O') dfs(i,n-1,nums);
        }

        for(int j=0;j<n;j++){
            if(nums[0][j]=='O') dfs(0,j,nums);
            if(nums[m-1][j]=='O') dfs(m-1,j,nums);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j]=='#') nums[i][j] = 'O';
                else if(nums[i][j]=='O') nums[i][j] = 'X';
            }
        }

    }

    public void dfs(int i,int j,char[][] nums){
        if(i<0 || j<0 || i>=nums.length || j>=nums[0].length || nums[i][j]!='O') return;
        
        nums[i][j] = '#';

        dfs(i-1,j,nums);
        dfs(i+1,j,nums);
        dfs(i,j-1,nums);
        dfs(i,j+1,nums);
    }
}
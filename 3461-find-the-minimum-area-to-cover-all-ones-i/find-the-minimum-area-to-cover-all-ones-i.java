class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int l = 0; int r = m-1;
        int t = 0; int b = n-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    l = Math.max(j,l);
                    r = Math.min(j,r);

                    t = Math.max(i,t);
                    b = Math.min(i,b);
                }
            }
        }
        // System.out.print(l+" "+r+" "+t+" "+b);
        return (l-r+1)*(t-b+1);

    }
}
class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean [] visit = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i,visit,adj);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i,boolean [] visit,int [][] adj){
        int n = adj.length;
        visit[i] = true;
        for(int j=0;j<n;j++){
            if(!visit[j] && adj[i][j]==1){
                visit[j] = true;
                dfs(j,visit,adj);
            }
        }
        return;
    }
}
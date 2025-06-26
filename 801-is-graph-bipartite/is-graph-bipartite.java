class Solution {
    public boolean ans;
    public boolean isBipartite(int[][] adj) {
       int n = adj.length;
       ans = true;
       int [] visit = new int[n];
       Arrays.fill(visit,-1);
       for(int i=0;i<n;i++){
        if(visit[i]==-1){
            if(ans==false) return ans;
            bfs(i,visit,adj);
        }
       }
       return ans;
    }
    public void bfs(int s,int [] visit,int [][] adj){
        visit[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(q.size()>0){
            int front = q.poll();
            int color = visit[front];
            for(int elem:adj[front]){
                if(visit[elem]==visit[front]){
                    ans = false;
                    return;
                }
                if(visit[elem]==-1){
                    q.add(elem);
                    visit[elem] = 1-color;
                }
            }
        }
    }
}
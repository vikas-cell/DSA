class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        
         for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean [] visit = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visit[i]){
                if(bfs(i,visit,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(int s,boolean [] visit,ArrayList<ArrayList<Integer>> adj){
        visit[s] = true;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{s,-1});
        
        while(q.size()>0){
            int [] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            
            for(int elem:adj.get(node)){
                if(!visit[elem]){
                    q.add(new int[] {elem,node});
                    visit[elem] = true;
                }
                else if(elem!=parent) return true;
            }
        }
        return false;
    }
}
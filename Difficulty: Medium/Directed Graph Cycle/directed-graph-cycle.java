// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

class Solution {
    public boolean ans;
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }
        ans = false;
        boolean [] visit = new boolean[V];
        boolean [] path = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visit[i]){
                dfs(i,adj,path,visit);
            }
        }
        return ans;
    }
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean [] path,boolean [] visit){
        visit[i] = true;
        path[i] = true;
        for(int elem:adj.get(i)){
            if(path[elem]){
                ans = true;
                return;
            }
            if(!visit[elem]) dfs(elem,adj,path,visit);
        }
        path[i] = false;
    }
}

class Solution {
    public int parent[];
    public int size[];
    public boolean pairity[];
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u,int v){
        int a = find(u);
        int b = find(v);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a]+=size[b];
                pairity[v] = !pairity[u];
            }
            else{
                parent[a] = b;
                size[b]+=size[a];
                pairity[u] = !pairity[v];
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        pairity = new boolean[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
            pairity[i] = false;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int u = i; int v = graph[i][j];
                if(v>u){
                    if(find(u)==find(v)){
                        if(pairity[u]==pairity[v]) return false;
                    }
                    else{
                        union(u,v);
                    }
                }
            }
        }
        return true;
    }
}
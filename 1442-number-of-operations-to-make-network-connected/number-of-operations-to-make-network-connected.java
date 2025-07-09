class Solution {
    public  int [] size;
    public  int [] parent;
    
    public  int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }
    
    public  void union(int u,int v){
        int a = find(u);
        int b = find(v);
        
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a]+=size[b];
            }
            else{
                parent[a] = b;
                size[b]+=size[a];
            }
        }
    }
    public int makeConnected(int n, int[][] edge) {
        int m = edge.length;
        int extracount = 0;
        parent = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int i=0;i<m;i++){
            int u = edge[i][0]; int v = edge[i][1];
            if(find(u)!=find(v)){
                union(u,v);
            }
            else extracount++;
         }
         
        int count = 0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) count++;
        }
        if(extracount>=count-1) return count-1;
        return -1;
    }
}
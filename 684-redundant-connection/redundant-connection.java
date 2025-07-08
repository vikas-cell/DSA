class Solution {
    public int [] parent;
    public int [] size;
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
            }
            else{
                parent[a] = b;
                size[b]+=size[a];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1;i<=n;i++){
          parent[i] = i;
          size[i] = 1;
        }
        
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            // System.out.println(find(u)+" "+find(v));
            if(find(u)==find(v)){
                return new int[]{u,v};
            }
            else{
                union(u,v);
            }
        }
        return new int[0];
    }
}
// User function Template for Java
class Solution {
    public static int [] parent;
    public static int [] size;
    
    public static int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }
    
    public static void union(int u,int v){
        int a = find(u);
        int b = find(v);
        
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a] = size[a]+size[b];
            }
            else{
                parent[a] = b;
                size[b] = size[a]+size[b];
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        parent = new int[V];
        size = new int[V];
        
        for(int i=0;i<V;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int sum = 0;
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            if(find(v)!=find(u)){
                sum = sum + wt;
                union(u,v);
            }
        }
        return sum;
    }
}

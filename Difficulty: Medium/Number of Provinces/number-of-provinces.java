// User function Template for Java
class Solution {
    public static int [] size;
    public static int [] parent;
    
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
                size[a]+=size[b];
            }
            else{
                parent[a] = b;
                size[b]+=size[a];
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n = V;
        parent = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int u = i; int v = j;
                if(find(u)!=find(v) && adj.get(u).get(v)==1){
                    union(u,v);
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
};
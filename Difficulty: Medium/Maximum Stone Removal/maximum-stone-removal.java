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
    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxr = 0; int maxc = 0;
        for(int i=0;i<stones.length;i++){
            maxr = Math.max(maxr,stones[i][0]);
            maxc = Math.max(maxc,stones[i][1]);
        }
        
        int total =maxr+maxc+2;
        parent = new int[total];
        size = new int[total];
        
        for(int i=0;i<total;i++){
            size[i] = 1;
            parent[i] = i;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int u = stones[i][0];
            int v = stones[i][1]+maxr+1;
            union(u,v);
            map.put(u,1);
            map.put(v,1);
        }
        int count=  0;
        for(int elem:map.keySet()){
            if(find(elem)==elem)
            count++;
        }
        return n-count;
    }
};

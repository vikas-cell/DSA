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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int count = 0;
        int maxr = 0; int maxc = 0;
        for(int i=0;i<n;i++){
            maxr = Math.max(maxr,stones[i][0]);
            maxc = Math.max(maxc,stones[i][1]);
        }

        int total = maxr+maxc+2;
        size = new int[total];
        parent = new int[total];
        for(int i=0;i<total;i++){
            size[i] = 1;
            parent[i] = i;
        }

        HashSet<Integer> set  = new HashSet<>();
        for(int i=0;i<n;i++){
            int u = stones[i][0];
            int v = stones[i][1]+maxr+1;
            union(u,v);
            set.add(u);
            set.add(v);
        }
        for(Integer elem:set){
            if(find(elem)==elem)
            count++;
        }
        return n-count;
    }
}
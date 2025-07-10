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
    public boolean isValid(int adjr,int adjc,int n,int m){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
    }
    public int largestIsland(int[][] grid) {
       int n = grid.length; int m = grid[0].length;
        int total = n*m;
        size = new int[total];
        parent = new int[total];
        
        for(int i=0;i<total;i++){
            size[i] = 1;
            parent[i] = i;
        }
        
        int max = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) continue;
                
                int [] dr = {-1,0,+1,0};
                int [] dc = {0,+1,0,-1};
                
                for(int idx=0;idx<4;idx++){
                    int adjr = i+dr[idx];
                    int adjc = j+dc[idx];
                    
                    if(isValid(adjr,adjc,n,m) && grid[adjr][adjc]==1){
                        int nodeNo = m*i+j;
                        int adjNodeNo = m*adjr+adjc;
                        union(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> set = new HashSet<>();
                int [] dr = {-1,0,+1,0};
                int [] dc = {0,-1,0,+1};
                
                for(int idx=0;idx<4;idx++){
                    int adjr = i+dr[idx];
                    int adjc = j+dc[idx];
                    
                    if(isValid(adjr,adjc,n,m) && grid[adjr][adjc]==1){
                        int adjNodeNo = m*adjr+adjc;
                        set.add(find(adjNodeNo));
                    }
                }
                int totalsize = 0;
                for(Integer elem:set){
                    totalsize+=size[elem];
                }
                max = Math.max(max,totalsize+1);
            }
        }
        
        for(int i=0;i<total;i++){
            max = Math.max(max,size[find(i)]);   
        }
        
        return max; 
    }
}
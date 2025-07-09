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
    
    public boolean isValid(int adjr,int adjc,int n,int m){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        int total = m*n;
        parent = new int[total];
        size = new int[total];
        
        for(int i=0;i<total;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int [][] visit = new int[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(visit[row][col]==1){
                ans.add(count);
                continue;
            }
            
            visit[row][col] = 1;
            count++;
            
            int [] dr = {-1,0,+1,0};
            int [] dc = {0,+1,0,-1};
            
            for(int idx=0;idx<4;idx++){
                int adjr = row+dr[idx];
                int adjc = col+dc[idx];
                
                if(isValid(adjr,adjc,n,m)){
                    if(visit[adjr][adjc]==1){
                        int nodeNo = m*row+col;
                        int adjNodeNo = m*adjr+adjc;
                        if(find(nodeNo)!=find(adjNodeNo)){
                            count--;
                            union(nodeNo,adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
       return ans;
    }
}
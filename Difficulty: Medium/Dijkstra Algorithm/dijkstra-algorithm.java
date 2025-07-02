class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int []>> al = new ArrayList<>();
        for(int i=0;i<V;i++) al.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            al.get(a).add(new int[]{b,c});
            al.get(b).add(new int[]{a,c});
        }
        int [] ans = new int[V];
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<V;i++) ans[i] = Integer.MAX_VALUE;
        ans[src] = 0;
        
        for(int [] mat:al.get(src)){
            int e = mat[0];
            int c = mat[1];
            ans[e] = c;
            q.add(new int[]{e,c});
        }
        
        while(q.size()>0){
            int [] pair = q.poll();
            int e = pair[0];
            int c = pair[1];
            for(int [] mat:al.get(e)){
                int ed = mat[0];
                int cc = mat[1];
                if(ed!=src && c+cc<ans[ed]){
                    ans[ed] = c+cc;
                    q.add(new int[]{ed,c+cc});
                }
            }
        }
        return ans;
    }
}
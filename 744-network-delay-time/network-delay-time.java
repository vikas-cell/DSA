class Solution {
    public int networkDelayTime(int[][] edges, int V, int src) {
         ArrayList<ArrayList<int []>> al = new ArrayList<>();
        for(int i=0;i<V;i++) al.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            al.get(a-1).add(new int[]{b-1,c});
            // al.get(b-1).add(new int[]{a-1,c});
        }
        int [] dist = new int[V];
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        dist[src-1] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src-1,0});
        
        while(pq.size()>0){
            int [] p = pq.poll();
            int u = p[0];
            int d_u = p[1];
            for(int [] mat:al.get(u)){
                int v = mat[0];
                int cost = mat[1];
                if(dist[u]+cost<dist[v]){
                    dist[v] = dist[u]+cost;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        for(int i=0;i<V;i++) System.out.print(dist[i]+" ");
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<V;i++) ans = Math.max(ans,dist[i]);
        System.out.print(ans);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
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
        int [] dist = new int[V];
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0});
        
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
        return dist;
    }
}
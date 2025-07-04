class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int c = edges[i][2];
            
            adj.get(u).add(new int[]{v,c});
            adj.get(v).add(new int[]{u,c});
        }
        
        int [] dist = new int[V];
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});
        dist[src]=0;
        
        while(pq.size()>0){
            int [] p = pq.poll();
            int u = p[0];
            int d_u = p[1];
            
            for(int [] mat:adj.get(u)){
                int v = mat[0];
                int cost = mat[1];
                if(dist[u]+cost<dist[v]){
                    dist[v]=dist[u]+cost;
                    pq.offer(new int[]{v,dist[u]+cost});
                }
            }
        }
        return dist;
    }
}
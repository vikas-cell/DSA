class Solution {
    public int countPaths(int V, int[][] edges) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int c = edges[i][2];
            
            adj.get(u).add(new int[]{v,c});
            adj.get(v).add(new int[]{u,c});
        }

        long [] dist = new long[V];
        int [] ways = new int[V];

        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long []> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{0,0});

        int mod = 1000000007;

        while(pq.size()>0){
            long [] curr = pq.poll();
            int u = (int)curr[0];
            long d = curr[1];
            
            if(d>dist[u]) continue;

            for(int [] mat:adj.get(u)){
                int v = mat[0];
                int time = mat[1];

                if(dist[u]+time<dist[v]){
                    dist[v] = dist[u]+time;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v,dist[u]+time});
                }
                else if(dist[u]+time==dist[v]){
                    ways[v] = (ways[v]+ways[u])%mod;
                }
            }
        }
        return ways[V-1];
    }
}
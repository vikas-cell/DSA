class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new int[]{v,t});
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        dist[k] = 0;
        
        while(pq.size()>0){
            int [] p = pq.poll();
            int u = p[0];
            int dist_u = p[1];
            if(dist_u>dist[u]) continue;
            for(int [] mat:adj.get(u)){
                int v = mat[0];
                int cost = mat[1];
                if(dist_u+cost<dist[v]){
                    dist[v] = dist_u+cost;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
            int ans = Integer.MIN_VALUE;
            for(int i=1;i<=n;i++) ans = Math.max(ans,dist[i]);
            if(ans==Integer.MAX_VALUE) return -1;
            return ans;
    }
}
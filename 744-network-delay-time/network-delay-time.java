class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node,int time){
            this.node = node;
            this.time = time;
        }

        public int compareTo(Pair p){
            return this.time-p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];

            adj.get(u).add(new Pair(v,time));
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(k,0));

        while(pq.size()>0){
            Pair p = pq.poll();
            int u = p.node;
            int dist_u = p.time;
            for(Pair curr:adj.get(u)){
                int v = curr.node;
                int cost = curr.time;
                if(cost+dist_u<dist[v]){
                    dist[v] = cost+dist_u;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
        int ans = -1;
        for(int i=1;i<=n;i++) ans = Math.max(ans,dist[i]);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
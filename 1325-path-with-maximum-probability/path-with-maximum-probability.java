class Solution {
   public class Pair implements Comparable<Pair>{
        int node;
        double cost;
        Pair(int node,double cost){
            this.node = node;
            this.cost = cost;
        }
        public int compareTo(Pair p){
           return Double.compare(p.cost, this.cost);
      }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];
            adj.get(u).add(new Pair(v,cost));
            adj.get(v).add(new Pair(u,cost));
        }

        double [] dist = new double[n];
        Arrays.fill(dist,0);
        dist[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start_node,1));

        while(pq.size()>0){
            Pair p = pq.poll();
            int u = p.node;
            double cost_u = p.cost;
            
            for(Pair curr:adj.get(u)){
                int v = curr.node;
                double cost_v = curr.cost;

                if(dist[v]<cost_v*cost_u){
                    dist[v] = cost_v*cost_u;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
        return dist[end_node];
    }
}
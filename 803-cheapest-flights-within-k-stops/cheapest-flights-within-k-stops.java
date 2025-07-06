class Solution {
    public class Pair{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
    }
     public class Triplet{
        int node;
        int cost;
        int stop;
        Triplet(int node,int cost,int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());
       for(int i=0;i<flights.length;i++){
        int u = flights[i][0];
        int v = flights[i][1];
        int cost = flights[i][2];

        adj.get(u).add(new Pair(v,cost));
       }

       int [] dist = new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src] = 0;
       Queue<Triplet> q = new LinkedList<>();
       q.add(new Triplet(src,0,0));

       while(q.size()>0){
        Triplet t = q.poll();
        int u = t.node; int cost_u = t.cost; int stops = t.stop;
        if(stops==k+1) break;

        for(Pair p:adj.get(u)){
          int v = p.node;
          int cost_v = p.cost;
          if(cost_v+cost_u<dist[v]){
            dist[v] = cost_v+cost_u;
            q.add(new Triplet(v,dist[v],stops+1));
          }
        }
       }
       if(dist[dst]==Integer.MAX_VALUE) return -1;
       return dist[dst];
    }
}
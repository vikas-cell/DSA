class Solution {
    public static class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int weight;
        Triplet(int node,int parent,int weight){
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
        public int compareTo(Triplet t){
            return this.weight-t.weight;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean visit [] = new boolean[V];
        int sum = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while(pq.size()>0){
            Triplet t = pq.poll();
            int u = t.node;
            int p = t.parent;
            int wt_u= t.weight;
            if(!visit[u]) sum = sum + wt_u;
            visit[u] = true;
            for(int [] mat:adj.get(u)){
                int v = mat[0];
                int wt_v = mat[1];
                if(visit[v]==false){
                    pq.add(new Triplet(v,u,wt_v));
                }
            }
        }
      return sum;
    }
}
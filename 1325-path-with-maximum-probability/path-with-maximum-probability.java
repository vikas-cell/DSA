class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double []>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double c = succProb[i];
            adj.get(a).add(new double[]{b,c});
            adj.get(b).add(new double[]{a,c});
        }
        double [] prob = new double[n];
        Arrays.fill(prob,0);
        PriorityQueue<double []> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        prob[start_node] = 1.0;
        pq.offer(new double[]{1.0,start_node});
        while(pq.size()>0){
            double [] pair = pq.poll();
            double d = pair[0];
            int u = (int)pair[1];
            for(double [] mat:adj.get(u)){
                double cost = mat[1];
                int v =(int) mat[0];
                if(cost*prob[u]>prob[v]){
                    prob[v] = cost*prob[u];
                    pq.offer(new double[]{prob[v],v});
                }

            }
        } 
        return prob[end_node];
    }
}
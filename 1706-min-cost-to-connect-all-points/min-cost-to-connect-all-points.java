class Solution {
    public class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int dist;
        Triplet(int node,int parent,int dist){
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
        public int compareTo(Triplet t){
            return this.dist-t.dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int n = points.length;
        boolean [] visit = new boolean[n];
        pq.add(new Triplet(0,-1,0));
        
        while(pq.size()>0){
            Triplet top = pq.poll();
            int node = top.node; int parent = top.parent; int dist = top.dist;
            if(visit[node]) continue;
            sum = sum + dist;
            visit[node] = true;

            for(int i=0;i<n;i++){
                // if(i==parent || i==node) continue;
                if(visit[i]) continue;

                int x1 = points[node][0]; int y1 = points[node][1];
                int x2 = points[i][0]; int y2 = points[i][1];
                int mDist = Math.abs(x1-x2)+Math.abs(y1-y2);
                pq.add(new Triplet(i,node,mDist));
            }
        }
        return sum;
    }
}
class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int effort;
        Triplet(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }

        public int compareTo(Triplet t){
            if(this.effort==t.effort) return this.row-t.row;
            return Integer.compare(this.effort,t.effort);
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length; int n = arr[0].length;
        int [][] dist = new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));

        while(pq.size()>0){
            Triplet t = pq.poll();
            int row = t.row; int col = t.col; int effort = t.effort;
            if(row==m-1 && col==n-1) break;

            if(row>0){// up
                int e = Math.abs(arr[row][col]-arr[row-1][col]);
                e = Math.max(e,effort);
                if(e<dist[row-1][col]){
                   dist[row-1][col] = e;
                   pq.add(new Triplet(row-1,col,e));
                }
            }

            if(col>0){//left
                int e = Math.abs(arr[row][col]-arr[row][col-1]);
                e = Math.max(e,effort);
                if(e<dist[row][col-1]){
                   dist[row][col-1] = e;
                   pq.add(new Triplet(row,col-1,e));
                }
            }
            if(row<m-1){//down
                int e = Math.abs(arr[row][col]-arr[row+1][col]);
                e = Math.max(e,effort);
                if(e<dist[row+1][col]){
                   dist[row+1][col] = e;
                   pq.add(new Triplet(row+1,col,e));
                }
            }
            if(col<n-1){//right
                int e = Math.abs(arr[row][col]-arr[row][col+1]);
                e = Math.max(e,effort);
                if(e<dist[row][col+1]){
                   dist[row][col+1] = e;
                   pq.add(new Triplet(row,col+1,e));
                }
            }
        }
        return dist[m-1][n-1];
    }
}
class Solution {
    public double maxAverageRatio(int[][] nums, int extra) {
        int n = nums.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
            double gainA = gain(a[0],a[1]);
            double gainB = gain(b[0],b[1]);
            return Double.compare(gainB,gainA);
        });

        for(int [] arr:nums){
            pq.offer(arr);
        }

        while(extra-->0){
            int [] best = pq.poll();
            best[0]++;
            best[1]++;
            pq.offer(best);
        }

        double total = 0.0;

        for(int [] arr:pq){
            total += (double)arr[0]/arr[1];
        }
        return total/n;
    }

    public double gain(int pass,int total){
       double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }
}
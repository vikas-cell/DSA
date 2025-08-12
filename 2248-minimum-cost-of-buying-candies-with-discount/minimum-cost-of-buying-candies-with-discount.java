class Solution {
    public int minimumCost(int[] cost) {
       int n = cost.length;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       int ans = 0;

       for(int i=0;i<n;i++){
        pq.add(cost[i]);
       }

       while(pq.size()>0){
        
        if(pq.size()>0){
           ans = ans + pq.poll();
        }
        if(pq.size()>0){
            ans = ans + pq.poll();
        }

        if(pq.size()>0){
            pq.poll();
        }
       }
      return ans;
    }
}
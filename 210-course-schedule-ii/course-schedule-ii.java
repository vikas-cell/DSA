class Solution {
    public int[] findOrder(int n, int[][] nums) {
         int [] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int a = nums[i][0];
            int b = nums[i][1];
            adj.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        if(q.size()==0) return new int[0];
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            int curr = q.poll();
            ans.add(curr);

            for(int elem:adj.get(curr)){
                indegree[elem]--;
                if(indegree[elem]==0) q.add(elem);
            }
        }
        if(ans.size()<n) return new int[0];
        Collections.reverse(ans);
        int [] al = new int[n];
        for(int i=0;i<n;i++) al[i] = ans.get(i);
        return al;
    }
}
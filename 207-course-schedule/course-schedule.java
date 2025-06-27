class Solution {
    public boolean canFinish(int n, int[][] nums) {
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
        if(q.size()==0) return false;
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            int curr = q.poll();
            ans.add(curr);

            for(int elem:adj.get(curr)){
                indegree[elem]--;
                if(indegree[elem]==0) q.add(elem);
            }
        }
        if(ans.size()<n) return false;
        return true;
    }
}
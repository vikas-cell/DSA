class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int [] indegree = new int[n];
        for(int i=0;i<n;i++){
           for(int j:graph[i]){
            adj.get(j).add(i);
            indegree[i]++;
           }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()>0){
            int curr = q.poll();
            ans.add(curr);
            for(int elem:adj.get(curr)){
                indegree[elem]--;
                if(indegree[elem]==0) q.add(elem);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }
        
        int[] indegree = new int[V];
        
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            
            for (int elem : adj.get(curr)) {
                indegree[elem]--;
                if (indegree[elem] == 0) {
                    q.add(elem);
                }
            }
        }
        
        return ans.size() < V;
    }
}

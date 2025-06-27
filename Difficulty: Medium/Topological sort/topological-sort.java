import java.util.*;

class Solution {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean[] visit = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                dfs(i, adj, visit, ans);
            }
        }
        Collections.reverse(ans); // finish topological order
        return ans;
    }

    public static void dfs(int s, ArrayList<ArrayList<Integer>> adj,
                           boolean[] visit, ArrayList<Integer> ans) {
        visit[s] = true;
        for (int j : adj.get(s)) {
            if (!visit[j]) {
                dfs(j, adj, visit, ans);
            }
        }
        ans.add(s);
    }
}
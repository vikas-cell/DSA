class Solution {
    public int findCircleNum(int[][] nums) {
        int n = nums.length;
        int count = 0;
        boolean visit[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                bfs(i,nums,visit);
                count++;
            }
        }
        return count;
    }
    public void bfs(int s,int [][] nums,boolean [] visit){
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s] = true;
        while(q.size()>0){
            int elem = q.poll();
            for(int i=0;i<n;i++){
                if(!visit[i] && nums[elem][i]==1){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
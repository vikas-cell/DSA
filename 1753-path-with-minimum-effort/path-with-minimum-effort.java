class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = heights[0][0];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                high = Math.max(high,heights[i][j]);
            }
        }
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(helper(mid,heights)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public boolean helper(int effort,int [][] nums){
        int n = nums.length; int m = nums[0].length;
        int [][] visit = new int[n][m];
        Queue<int [] > q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visit[0][0]=1;
        while(q.size()>0){
            int [] p = q.poll();
            int i = p[0];
            int j = p[1];
            if(i>0 && visit[i-1][j]==0 && Math.abs(nums[i][j]-nums[i-1][j])<=effort){
                q.add(new int[]{i-1,j});
                visit[i-1][j] = 1;
            }
            if(i<n-1 && visit[i+1][j]==0 && Math.abs(nums[i][j]-nums[i+1][j])<=effort){
                q.add(new int[]{i+1,j});
                visit[i+1][j] = 1;
            }
            if(j>0 && visit[i][j-1]==0 && Math.abs(nums[i][j]-nums[i][j-1])<=effort){
                q.add(new int[]{i,j-1});
                visit[i][j-1] = 1;
            }
            if(j<m-1 && visit[i][j+1]==0 && Math.abs(nums[i][j]-nums[i][j+1])<=effort){
                q.add(new int[]{i,j+1});
                visit[i][j+1] = 1;
            }
        }
        if(visit[n-1][m-1]==1) return true;
        return false;
    }
}
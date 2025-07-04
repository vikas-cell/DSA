class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) for(int j=0;j<=target;j++) dp[i][j] = -1;
        return helper(0,nums,target,dp);
    }
    public int helper(int idx,int [] nums,int target,int [][] dp){
        if(target==0 && idx==nums.length) return 1;
        if(idx>=nums.length || target<0) return 0;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int skip = helper(idx+1,nums,target,dp);
        if(nums[idx]>target) return dp[idx][target]=skip;
        int pick = helper(idx+1,nums,target-nums[idx],dp);
        return dp[idx][target]=skip+pick;
    }
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum = sum+nums[i];
            max = Math.max(sum,max);
            if(sum<0) sum =0;
        }
        return max;
    }
}
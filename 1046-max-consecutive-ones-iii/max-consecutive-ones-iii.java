class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int i=0; int j=0;
        int n = nums.length;
        int max = 0;
        while(j<n){
            if(zero>k){
                if(nums[i]==0) zero--;
                i++;
            }
            if(nums[j]==0) zero++;
            if(zero<=k) max = Math.max(j-i+1,max);
            j++;
        }
        return max;
    }
}
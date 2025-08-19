class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int i = 0;
        while(i<n){
            int j = i;
            int k = i;
            while(j<n && nums[j]==0){
                i++; j++;
            }
            long elem = (j-k);
            ans = ans + (elem*(elem+1))/2;
            i++;
        }
        return ans;
    }
}
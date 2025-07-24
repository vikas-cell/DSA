class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for(int i=0;i<left.length;i++){
            int ans = left[i]-0;
            max = Math.max(max,ans);
        }
        
        for(int i=0;i<right.length;i++){
            int ans = n-right[i];
            max = Math.max(max,ans);
        }
        return max;
    }
}
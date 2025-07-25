class Solution {
    public int maxSubarraySumCircular(int[] arr){
        int minsum = Integer.MAX_VALUE;
        int maxsum = Integer.MIN_VALUE;
        int sum = 0; 
        int currmin = 0;
        int currmax = 0;
        int n = arr.length;
        
        for(int i=0;i<n;i++) sum = sum+arr[i];
        
        for(int i=0;i<n;i++){
            currmin = currmin+arr[i];
            minsum = Math.min(minsum,currmin);
            if(currmin>0) currmin=0;
        }
        
        for(int i=0;i<n;i++){
            currmax = currmax+arr[i];
            maxsum = Math.max(maxsum,currmax);
            if(currmax<0) currmax = 0;
        }
        
        if(maxsum<0) return maxsum;
        
        return Math.max(maxsum,sum-minsum);
    }
}
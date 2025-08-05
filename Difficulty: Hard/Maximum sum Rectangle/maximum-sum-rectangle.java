class Solution {
    public int maxRectSum(int mat[][]) {
        // code here
        int ans = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        
        
        for(int left = 0;left<m;left++){
            int [] arr = new int[n];
            
            for(int right = left;right<m;right++){
                for(int i=0;i<n;i++){
                    arr[i]+=mat[i][right];
                }
            int currmax = helper(arr);
            ans = Math.max(ans,currmax);
            }
        }
        return ans;
    }
    
    public int helper(int [] arr){
        int n = arr.length;
        int max = arr[0];
        int sum = arr[0];
        
        for(int i=1;i<n;i++){
            sum = Math.max(arr[i]+sum,arr[i]);
            max = Math.max(sum,max);
            
        }
        return max;
    }
};
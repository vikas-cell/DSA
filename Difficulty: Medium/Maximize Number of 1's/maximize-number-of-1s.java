class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int n = arr.length; int i=0; int j=0;
        int ans = 0;
        int zero = 0;
        
        while(j<n){
            
            if(zero>k){
                if(arr[i]==0) zero--;
                i++;
            }
            if(arr[j]==0) zero++;
            if(zero<=k) ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
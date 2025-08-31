class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        
        int i =0; int j = arr.length-1;
        int ans = 0;
        
        while(i<j){
            int wt = Math.min(arr[i],arr[j])*(j-i);
            ans = Math.max(ans,wt);
            if(arr[i]<arr[j]) i++;
            else j--;
        }
        return ans;
    }
}
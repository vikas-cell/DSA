class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        int n = arr.length;
        int [][] nums = new int[n][2];
        
        for(int i=0;i<n;i++){
            nums[i][0] = Math.abs(arr[i]-x);
            nums[i][1] = arr[i];
        }
        
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            arr[i] = nums[i][1];
        }
    }
}

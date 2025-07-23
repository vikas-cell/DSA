class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum = sum + arr[i]*(n-i)*(i+1);
        }
        return sum;
    }
}

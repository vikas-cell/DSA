class Solution {
    public int countValid(int n, int[] arr) {
        // code here
        int total = 9*(int)Math.pow(10,n-1);
        int s = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) s--;
        }
        
        int a = 10-arr.length;
        int y = (9-s)*(int)Math.pow(a,n-1);
        return total-y;
    }
}
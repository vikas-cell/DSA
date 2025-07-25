



class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int maxCircularSum(int arr[]) {

        // Your code here
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int currMin=0;
        int currMax=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        
        for(int i=0;i<arr.length;i++){
            currMin=Math.min(arr[i],arr[i]+currMin);
            min=Math.min(currMin,min);
        }
        
        
        for(int i=0;i<arr.length;i++){
            currMax=Math.max(arr[i],currMax+arr[i]);
            max=Math.max(max,currMax);
           
        }
        if(max<0) return max;
        return Math.max(max,sum-min);
    }
}

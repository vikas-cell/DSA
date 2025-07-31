class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
       int max = 0;
       int n = intervals.length;
       
       for(int i=0;i<n;i++){
           if(intervals[i][1]>max){
               max = intervals[i][1];
           }
       }
       
       int [] arr = new int[max+2];
       
       for(int i=0;i<n;i++){
           int st = intervals[i][0];
           int end = intervals[i][1];
           
           arr[st]++;
           arr[end+1]--;
       }
       
       for(int i=1;i<max+2;i++){
           arr[i] = arr[i-1]+arr[i];
       }
       
       for(int i=max+1;i>=0;i--){
           if(arr[i]>=k) return i;
       }
       return -1;
    }
}


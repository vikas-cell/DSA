class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        
       int n = intervals.length;
        int [][] arr = new int[n+1][2];
        for(int i=0;i<n;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[n][0] = newInterval[0]; 
        arr[n][1] = newInterval[1]; 

        int [][] ans = merge(arr);
        
        ArrayList<int [] > al = new ArrayList<>();
        
        for(int i=0;i<ans.length;i++){
            int [] elem = new int[2];
            elem[0] = ans[i][0];
            elem[1] = ans[i][1];
            
            al.add(elem);
        }
        
        return al;
        
    }
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int []> ans = new ArrayList<>();
        int start = nums[0][0]; int end = nums[0][1];

        for(int i=1;i<nums.length;i++){
            int s = nums[i][0];
            int e = nums[i][1];

            if(s<=end){
                end = Math.max(e,end);
            }
            else{
                ans.add(new int[]{start,end});
                start = s;
                end = e;
            }
        }

        ans.add(new int[]{start,end});

        int [][] arr = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            int [] p = ans.get(i);
            arr[i][0] = p[0];
            arr[i][1] = p[1];
        }
        return arr;
    }
}

class Solution {
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
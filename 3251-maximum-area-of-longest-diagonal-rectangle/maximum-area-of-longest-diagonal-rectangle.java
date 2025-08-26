class Solution {
    public int areaOfMaxDiagonal(int[][] nums){
        int area = Integer.MIN_VALUE; int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++){
            int a = nums[i][0];
            int b = nums[i][1];

            int d = a*a+b*b;

            if(ans<=d){
                if(ans<d) area = a*b;
                else area = Math.max(area,a*b);

                ans = d;
            }
        }

        return area;
    }
} 
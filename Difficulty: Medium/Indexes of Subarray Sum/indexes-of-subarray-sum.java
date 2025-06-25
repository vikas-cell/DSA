


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int j = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + arr[i];
            while(sum>target){
                sum = sum - arr[j];
                j++;
            }
            if(sum==target){
                ans.add(j+1);
                ans.add(i+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
         
    }
}

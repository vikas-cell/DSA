class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int elem = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                elem = i;
                break;
            }
        }
        if(elem==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[elem]<nums[i]){
                swap(elem,i,nums);
                break;
            }
        }
        reverse(nums,elem+1,n-1);
    }
    public void reverse(int [] nums,int i,int j){
         while(i<j){
            swap(i,j,nums);
            i++; j--;
         }
    }
    public void swap(int i,int j,int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        for(int i=0;i<nums.length;i++){
            int rem = target-nums[i];
            if(map.containsKey(rem)){
                arr[0] = i;
                arr[1] = map.get(rem);
                break;
            }
            else map.put(nums[i],i);
        }
        return arr;
    }
}
class Solution {
    public static int firstMissingPositive(int[] arr) {
         HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
            max = Math.max(arr[i],max);
        }
        for(int i=1;i<=max;i++){
            if(!set.contains(i)) return i;
        }
        return max+1;
    }
}
class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0; int j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        while(j<n){
            if(map.containsKey(arr[j])){
                map.put(arr[j],map.get(arr[j])+1);
            }
            else map.put(arr[j],1);
            while(map.size()>2){
                int freq = map.get(arr[i]);
                map.put(arr[i],freq-1);
                if(freq==1) map.remove(arr[i]);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
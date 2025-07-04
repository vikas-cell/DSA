class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        int i=0; int j = 0;
        while(j<n){
            int key = arr[j];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else map.put(arr[j],1);
            
            while(map.size()>k){
                int freq = map.get(arr[i]);
                if(freq==1) map.remove(arr[i]);
                else map.put(arr[i],freq-1);
                i++;
            }
            if(map.size()<=k) count=count+(j-i+1);
            j++;
        }
        return count;
    }
}

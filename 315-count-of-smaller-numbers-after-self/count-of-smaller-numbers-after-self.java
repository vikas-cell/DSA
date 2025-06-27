class Solution {
    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        int [] bit = new int[20002];
        for(int i=0;i<n;i++) arr[i] = arr[i]+10001;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            al.add(rangesum(arr[i]-1,bit));
            update(arr[i],bit);
        }
        Collections.reverse(al);
        return al;
    }
    public int rangesum(int i,int [] bit){
        int res = 0;
        while(i>0){
            res = res+bit[i];
            i = i-(i&(-i));
        }
        return res;
    }

    public void update(int i,int [] bit){
        while(i<bit.length){
            bit[i]+=1;
            i = i+(i&(-i));
        }
    }
}
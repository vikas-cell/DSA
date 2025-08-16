class Solution {
    public int maximum69Number (int num) {
        ArrayList<Integer> al = new ArrayList<>();
        while(num>0){
            al.add(num%10);
            num = num/10;
        }
        Collections.reverse(al);
        int n = al.size();
        for(int i=0;i<n;i++){
            if(al.get(i)==6){
              al.set(i,9);
              break;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
          ans = ans*10+al.get(i);
        }
        return ans;
    }
}
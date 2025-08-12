class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n = prices.length;
        ArrayList<Integer> al = new ArrayList<>();
        int min = 0;
        int max = 0;
        Arrays.sort(prices);
        
        int i=0; int j=n-1;
        
        while(i<=j){
            min = min+prices[i];
            i++;
            j = j-k;
        }
        
        i=0; j=n-1;
        
        while(i<=j){
            max = max+prices[j];
            j--;
            i= i+k;
        }
        
        
        al.add(min);
        al.add(max);
        return al;
    }
}

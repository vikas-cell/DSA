class Solution {
    public String intToRoman(int num) {
        String ans="";
        String [] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        for(int i=0;i<13;i++){
            while(num>=values[i]){
                ans = ans + symbols[i];
                num = num - values[i];
            }
        }

        return ans;
    }
}
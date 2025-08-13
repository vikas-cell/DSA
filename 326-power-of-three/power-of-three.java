class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0)
        return false;
        if(n==1)
        return true;

        else if(n>0){
            while(n>0){
                if(n%3!=0)
                return false;
                n = n/3;
                if(n==1)
                return true;
            }
        }
        else if(n<0){
             n = (-1)*n;
             int c = 0;
             while(n>0){
                if(n%3!=0)
                return false;
                n=n/3;
                c++;
             }
             if(c%2==0)
             return false;
        }
        return true;
    }
}
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k=1;k<=60;k++){
            long diff = (long)num1-(long)num2*k;

            if(diff<0) continue;

            int bits = Long.bitCount(diff);

            if(bits<=k && diff>=k) return k;
        }
        return -1;
    }
}
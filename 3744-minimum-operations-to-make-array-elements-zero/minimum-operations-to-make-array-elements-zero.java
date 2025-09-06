class Solution {
    public long minOperations(int[][] queries) {
        long result = 0;

        for(int [] q:queries){
            long l = q[0], r = q[1], sum = 0, operations = 0;

            for(int range=1;range<=r;range*=4){
               long st = Math.max(range,l);
               long ed = Math.min(r,4*range-1);

              sum+=Math.max(0L,++operations*(ed-st+1));
            }
            result+=(sum+1)/2;
        }
        return result;
    }
}
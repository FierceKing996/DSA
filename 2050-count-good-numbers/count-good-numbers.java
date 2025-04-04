class Solution {
    public static long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod; 

        while (exp > 0) {
            if ((exp & 1) == 1) { 
                result = (result * base) % mod;
            }
            base = (base * base) % mod; 
            exp >>= 1; 
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        if(n%2==0){
            long mod = (long)1e9+7;
            return (int)(power(5,n/2,mod)*(power(4,n/2,mod))%mod);
        }else{
            long mod = (long)1e9+7;
            return (int)(power(5,(n/2)+1,mod)*(power(4,n/2,mod))%mod);
        }
    }
}
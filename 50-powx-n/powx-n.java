class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
    if (n < 0) {
        x = 1 / x;
        if (n == Integer.MIN_VALUE) { 
            n = Integer.MAX_VALUE;
            x *= x;  
        } else {
            n = -n;
        }
    }
    
    double half = myPow(x, n / 2);
    
    return (n % 2 == 0) ? half * half : half * half * x;

    }
}
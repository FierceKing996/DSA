class Solution {
    int[] dp = new int[38];
    public int helper(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(dp[n]==-1)
            dp[n] = helper(n-1) + helper(n-2) + helper(n-3);
        return dp[n];
    }
    public int tribonacci(int n) {
        Arrays.fill(dp,-1);
        return helper(n);
    }
}
class Solution {
    
    static final long MOD = 1_000_000_007;

    public static long solution(int n, int[] money) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= MOD;
            }
        }

        return dp[n];
    }
}
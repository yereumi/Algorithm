class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[2][n + 1];
        dp[0][1] = money[0];
        dp[1][2] = money[1];
        for (int i = 3; i <= n; i++) {
            if (i < n - 1) {
                dp[0][i] = Math.max(dp[0][i - 2], dp[0][i - 3]) + money[i - 1];
                dp[1][i] = Math.max(dp[1][i - 2], dp[1][i - 3]) + money[i - 1];
            }
            else if (i == n - 1) {
                dp[0][i] = Math.max(dp[0][i - 2], dp[0][i - 3]) + money[i - 1];
                dp[1][i] = dp[1][i - 2];
            } else if (i == n) {
                dp[0][i] = dp[0][i - 2];
                dp[1][i] = Math.max(dp[1][i - 2], dp[1][i - 3]) + money[i - 1];
            }
        }
        return Math.max(Math.max(dp[0][n - 1], dp[0][n]), Math.max(dp[1][n - 1], dp[1][n]));
    }
}
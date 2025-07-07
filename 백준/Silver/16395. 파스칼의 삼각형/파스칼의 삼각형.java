import java.util.Scanner;

public class Main {
    public static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행 번호
        int k = sc.nextInt(); // 열 번호

        System.out.println(combination(n - 1, k - 1));
    }
}
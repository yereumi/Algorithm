/**
 * 시간 1초: 1억번 안에 연산
 * 최대 메모리 256MB: int 기준 대략 256 * 1000 * 1000 / 4 = 64_000_000개 할당 가능
 */
import java.util.*;
import java.io.*;

public class Main {
	
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        long[][] dp = new long[n + 1][10];
        long mod = 1_000_000_000;
        Arrays.fill(dp[1], 1);  
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
        	dp[i][0] = dp[i - 1][1] % mod;
        	dp[i][9] = dp[i - 1][8] % mod;
        	for (int j = 1; j < 9; j++) {
        		dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
        	}
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
        	answer = (answer + dp[n][i]) % mod;
        }
        System.out.println(answer);
    }
}
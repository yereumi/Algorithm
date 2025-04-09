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
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        	dp[i] = read();
        }
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= i / 2; j++) {
            	dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
        	}
        }
        System.out.println(dp[n]);
    }
}
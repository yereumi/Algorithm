/**
 * 시간 1초: 1억번 안에 연산
 * 최대 메모리 128MB: int 기준 대략 128 * 1000 * 1000 / 4 = 32_000_000개 할당 가능
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
        boolean[] dp = new boolean[n + 4];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;
        
        for (int i = 5; i <= n; i++) {
        	dp[i] = (!dp[i - 1]) || (!dp[i - 3]);
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}